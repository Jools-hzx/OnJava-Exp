package main.java.com.jools.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 17:18
 * @description: TODO
 */
public class StreamAreAutoCloseable {

    public static void main(String[] args) throws IOException {

        // 支持资源头内包含多个定义，使用分号分割。这个头部定义的每个对象都将在 try 块的末尾调用 close
        try (Stream<String> in =
                     Files.lines(Paths.get("StreamAreAutoCloseable.java"));
             PrintWriter outfile = new PrintWriter("Results.txt")
        ) {
            // try-with-resources 中的 try 块支持独立存在，没有 catch 和 finally。这里，IOException 会通过 main() 传递出去
            in.skip(5).limit(1)
                    .map(String::toUpperCase)
                    .forEachOrdered(outfile::println);
        }
    }
}
