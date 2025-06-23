package com.jools.io_;

import java.io.*;

/**
 * @author Jools He
 * @date 2025/6/21 15:44
 * @description: TODO
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws FileNotFoundException {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("xxx.java")))) {
            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
