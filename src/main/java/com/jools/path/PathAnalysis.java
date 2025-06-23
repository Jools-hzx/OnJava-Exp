package com.jools.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 18:13
 * @description: TODO
 */
public class PathAnalysis {

    public static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PathAnalysis").toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Is Dir", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("Writable", Files.isWritable(p));
        say("noExists", Files.notExists(p));
        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));     // 文件大小
        say("FileStore", Files.getFileStore(p));    // 位于目录
        say("LastModified", Files.getLastModifiedTime(p));    // 最后修改时间
        say("Owner", Files.getOwner(p));    // 文件所有者
        say("Content-Type", Files.probeContentType(p));     // 文件类型
    }
}
