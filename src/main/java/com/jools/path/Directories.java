package com.jools.path;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 18:46
 * @description: TODO
 */
public class Directories {

    static Path test = Paths.get("test");

    // 系统的分隔符
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    // refreshTestDir 检查 test 是不是已经失败了
    public static void refreshTestDir() throws Exception {
        if (Files.exists(test)) {   // 存在则删除
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {  // 否则创建
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        // 创建一个空文件并将文件名添加到 test 这个 path 的末尾
        Files.createDirectories(test.resolve("Hello.txt"));
        Path path = makeVariant();
        try {
            // 注意: 如果对于一个已经存在的目录调用了 createDirectory()，则会抛出异常
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println("Nope, that doesn't work!!!");
        }
        populateTestDir();
        // 在 test 目录下面创建一个临时目录；prefix 表示只有一个名字前缀选项
        Path tempDir = Files.createTempDirectory(test, "DIR_");
        // 创建一个临时文件到该临时目录下； 指定 前缀为 pre  后缀为 .non
        Files.createTempFile(tempDir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("-------------------------");
        Files.walk(test).forEach(System.out::println);
    }

    // 创建完整的目录路径，然后将这个文件的副本放置到最后一层目录内
    public static void populateTestDir() throws Exception {
        // 对每一个变种 variant, 使用 createDirectores() 创建了完整的目录路径
        for (int i = 0; i < parts.size(); i++) {
            Path v = makeVariant();
            if (!Files.exists(v)) {
                // 创建完整的目录路径
                Files.createDirectories(v);
                // 将该文本的副本放置到了最后一层目录中，但是更换了文件名称
                Files.copy(Paths.get("D:\\study\\onJava\\onjava-exp\\src\\main\\java\\com\\jools\\path\\Directories.java"), v.resolve("File.txt"));
                // 创建临时文件，没有指定后缀则默认是 .tmp
                Files.createTempFile(v, null, null);
            }
        }
    }
}
