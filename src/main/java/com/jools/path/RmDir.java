package com.jools.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 18:35
 * @description: TODO
 */
public class RmDir {

    /**
     * 访问者设计模式，提供了一个访问集合中的每个对象的标准机制，我们需要提供想在对象上执行操作
     * @param dir
     * @throws IOException
     */
    public static void rmdir(Path dir) throws IOException {
        Files.walkFileTree(dir,
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
    }
}
