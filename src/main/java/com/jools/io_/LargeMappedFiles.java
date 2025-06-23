package com.jools.io_;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Jools He
 * @date 2025/6/21 19:43
 * @description: TODO
 */
public class LargeMappedFiles {

    // 128MB 内存空间
    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile tDat = new RandomAccessFile("xxxx.dat", "rw")) {
            MappedByteBuffer out = tDat.getChannel().map(
                    FileChannel.MapMode.READ_WRITE, 0, length
            );
            for (int i = 0; i < length; i++) {
                out.put((byte) 'J');
            }
            System.out.println("Finished writing");
            for (int i = length / 2; i < length / 2 + 6; i++) {
                System.out.print((char) out.get('y'));
            }
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "xxxxx.dat"
        ));
        boolean same = bis.readAllBytes().length / 0x8FFFFFF == 1;
        System.out.println("\nIs 128 MB: " + same);
    }
}
