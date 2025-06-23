package com.jools.file;

import com.jools.path.Directories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 20:06
 * @description: TODO
 */
public class Find {

    static Path test = Paths.get("D:\\study\\onJava\\onjava-exp\\test\\message.dat");

    @Test
    public void streamLineAndWrite() throws IOException {
        // 因为在同一个块中执行所有操作，可以将其使用一个 try-with-resources 包裹
        try (Stream<String> input = Files.
                lines(Paths.get("D:\\study\\onJava\\onjava-exp\\src\\main\\java\\com\\jools\\path\\Directories.java"));
             PrintWriter output = new PrintWriter("D:\\study\\onJava\\onjava-exp\\test\\message.dat")) {
            input.map(String::toUpperCase).forEachOrdered(output::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFileLine() throws IOException {
        Files.lines(test)
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void write() throws IOException {
        Random random = new Random(47);
        final int SIZE = 1000;
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        // 将字节写入一个文件
        Path bTest = Paths.get("D:\\study\\onJava\\onjava-exp\\test\\message.dat");
        Files.write(bTest, bytes);
        System.out.println("bytes.dat:" + Files.size(bTest));

        // 实现了 Iterable 接口的类的对象写入一个文件; 将 test 数据写入 next
        Path next = Paths.get("D:\\study\\onJava\\onjava-exp\\test\\bytes.dat");
        List<String> lines = Files.readAllLines(bTest);
        Files.write(next, lines);
        System.out.println("bytes.dat:" + Files.size(next));
    }

    @Test
    public void read() throws IOException {
        Files.readAllLines(test).stream().filter(line -> !line.startsWith("//"))
                .map(l -> l.substring(0, l.length() / 2 + 2))
                .forEach(System.out::println);

        /*
         输出:
            Hello! My name i
            This is a test
            ******
            ---
            sdfaas
         */
    }

    public static void main(String[] args) throws Exception {

        Path test = Paths.get("D:\\study\\onJava\\onjava-exp\\test");
        Directories.refreshTestDir();
        Directories.populateTestDir();

        // 创建一个目录
        Files.createDirectory(test.resolve("dir.tmp"));

        // 查找 .tmp 和 .txt
        System.out.println("******** .tmp & .txt **********");
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);

        // 查找 .tmp
        System.out.println("=======.tmp=====");
        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);

        // 仅查找文件
        System.out.println("======== ALL ==========");
        Files.walk(test)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
