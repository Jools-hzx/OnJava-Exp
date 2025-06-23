package com.jools.io_;

import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Jools He
 * @date 2025/6/21 18:37
 * @description: TODO
 */
public class GetChannel {

    private static String name = "src/main/java/com/jools/io_/data.txt";
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {

        //写文件 - 写入第一个 Some text
        try (FileChannel fc = new FileOutputStream(name).getChannel()) {
            fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        }

        // 添加到文件末尾
        try (FileChannel fc = new RandomAccessFile(name, "rw").getChannel()) {
            fc.position(fc.size());     // 移动到尾部
            fc.write(ByteBuffer.wrap(
                    "Some more".getBytes()
            ));
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        // 读文件 - 查看结果，预期: Some text Some more
        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            buff.flip();
            while(buff.hasRemaining()) {
                System.out.write(buff.get());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.flush();
    }
}
