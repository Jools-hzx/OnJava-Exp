package com.jools.designpattern.builder;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Jools He
 * @date 2025/7/26 19:41
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty() || line.equals("exit")) {
                break;
            }
            switch (line) {
                case "plain":
                    TextBuilder plainBuilder = new TextBuilder();
                    Director plainDirector = new Director(plainBuilder);
                    plainDirector.construct();
                    System.out.println(plainBuilder.getResult());
                    break;
                case "html":
                    HTMLBuilder htmlBuilder = new HTMLBuilder();
                    Director htmlDirector = new Director(htmlBuilder);
                    htmlDirector.construct();
                    System.out.println(htmlBuilder.getResult());
                    break;
                default:
                    throw new RuntimeException("Unsupported command: " + line);
            }
        }

    }
}
