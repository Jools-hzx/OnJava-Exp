package com.jools.designpattern.trash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 3:06
 * @description: TODO
 */
public class ParseTrash {

    public static String source = "Trash.dat";

    public static <T extends Trash> void fillBin(String packageName, Fillable<T> bin) {
        DynaFactory factory =
                new DynaFactory(packageName);
        try {
            Files.lines(Paths.get("src/main/java/com/jools/designpattern/trash", source))
                    // Remove comments and empty lines:
                    .filter(line -> !line.trim().isEmpty())
                    .filter(line -> !line.startsWith("//"))
                    .forEach(line -> {
                        // 逐行获取 Trash 类型
                        String type = line.substring(
                                0, line.indexOf(':')).trim();
                        // z重量
                        double weight = Double.parseDouble(
                                line.substring(line.indexOf(':') + 1)
                                        .trim());
                        // 构建 TrashInfo DTO 实例进而构建 Trash
                        bin.addTrash(factory.create(
                                new TrashInfo(type, weight)));
                    });
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    // Special case to handle a List:
    public static <T extends Trash> void fillBin(String packageName, List<T> bin) {
        fillBin(packageName, new FillableList<>(bin));
    }

    // Basic test:
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        fillBin("com/jools/designpattern/trash".replaceAll("/", "."),
                bin);
        bin.forEach(System.out::println);
    }
}
