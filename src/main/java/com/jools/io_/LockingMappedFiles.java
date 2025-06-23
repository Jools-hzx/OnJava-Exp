package com.jools.io_;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author Jools He
 * @date 2025/6/21 20:16
 * @description: 对部分映射文件枷锁
 */
public class LockingMappedFiles {

    static final int LENGTH = 0x8FFFFFF; // 128 MB
    static FileChannel fc;

    public static void main(String[] args) throws IOException {

        fc = new RandomAccessFile("src/main/java/com/jools/io_/test.dat", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);

        // 第一次写入
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'o');
        }

        // 第二次写入；分部分写入
        new LockAndModify(out, 0, LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);

        /*
         输出结果:
            Locked: 0 to 50331647
            Locked: 75497471 to 113246206
            Released: 75497471 to 113246206
            Released: 0 to 50331647
        */
    }

    private static class LockAndModify extends Thread {

        private ByteBuffer buff;
        private int start, end;

        public LockAndModify(ByteBuffer mappedByteBuffer, int start, int end) {
            this.start = start;
            this.end = end;
            mappedByteBuffer.limit(end);    // 设置区间右边界
            mappedByteBuffer.position(start);   // 设置区间左边界(起点)
            // slice(): Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
            this.buff = mappedByteBuffer.slice();   // 分割得到子区间部分 [position, limit)
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                // 获取到锁，执行修改
                while (buff.position() < buff.limit() - 1) {
                    // 修改当前位置 + 1 的字节
                    buff.put((byte) (buff.get() + 1));
                }
                // 释放锁
                fl.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
