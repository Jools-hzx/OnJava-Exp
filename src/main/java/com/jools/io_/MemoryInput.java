package com.jools.io_;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Jools He
 * @date 2025/6/21 15:39
 * @description: TODO
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {

        StringReader in = new StringReader(
                BufferedInputFile.read("src/main/java/com/jools/io_/onjava-io.txt"));
        int c;
        while ((c = in.read()) != -1) {     // read() 会以 int 形式返回下一个字符；需要转换为 char 类型
            System.out.print((char) c);
        }

    }
}
