package com.jools.io_;

import java.io.*;

/**
 * @author Jools He
 * @date 2025/6/21 15:54
 * @description: TODO
 */
public class BasicFileOutput {

    static String file = "src/main/java/com/jools/io_/BasicFileOutput.dat";

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(
                        "src/main/java/com/jools/io_/BasicFileOutput.dat")));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(file));
    }
}
