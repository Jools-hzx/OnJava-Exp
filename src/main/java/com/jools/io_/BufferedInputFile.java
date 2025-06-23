package com.jools.io_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @date 2025/6/21 15:33
 * @description: TODO
 */
public class BufferedInputFile {


    public static String read(String filename) {
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            return in.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(read("src/main/java/com/jools/io_/onjava-io.txt"));
    }
}
