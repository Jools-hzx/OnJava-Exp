package com.jools.io_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author Jools He
 * @date 2025/6/21 20:01
 * @description: TODO
 */
public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {

        try (FileOutputStream fos = new FileOutputStream("src/main/java/com/jools/io_/data.dat");
             FileLock fl = fos.getChannel().tryLock()) {
            // Attempts to acquire an exclusive lock on this channel's file.
            if (fl != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(1000);
                fl.release();
                System.out.println("Release Lock");
            }
        }
    }
}
