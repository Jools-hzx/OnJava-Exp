package com.jools.io_;

import java.io.*;

/**
 * @author Jools He
 * @date 2025/6/21 16:05
 * @description: TODO
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {

        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(
                        "src/main/java/com/jools/io_/BasicFileOutput.dat"
                )))) {
            out.writeDouble(3.1415926);
            out.writeUTF("That was PI");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(
                        "src/main/java/com/jools/io_/BasicFileOutput.dat"
                )))) {
            System.out.println(in.readDouble());
            // 只有 readUTF() 可以正确地恢复 Java 的 UTF 字符串
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
