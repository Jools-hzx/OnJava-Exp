package com.jools.file;

import com.jools.path.Directories;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 19:43
 * @description: TODO
 */
public class PathWatcher {

    static Path test = Paths.get("D:\\study\\onJava\\onjava-exp\\test");

    static void delTextFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt")) // 必须显式调用 f.toString() 否则会比较整个 Path 对象
                    .forEach(f -> {
                        try {
                            System.out.println("Deleting :" + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE);
        // 以并行的方式开始运行
        Executors.newSingleThreadScheduledExecutor().schedule(
                PathWatcher::delTextFiles, 250, TimeUnit.MILLISECONDS
        );
        // 1. 会停止掉一切工作；直到某个事情发生才恢复
        WatchKey key = watcher.take();
        // 2. 返回一个包含 WatchEvent 的 WatchKey; Hello.txt 被删除之前，不会触发 WatchService
        //    注意它监听了这个目录，而不是它下面的一切，如果想要监听整个目录树，必须再整个目录树的子目录上设置 WatchService
        for (WatchEvent<?> event : key.pollEvents()) {
            System.out.println("event.context: " + event.context()
                    + "\nevent.count: " + event.count() +
                    "\nevent.kind: " + event.kind());
        }
        System.exit(0);

        /*
         输出:
            Deleting :D:\study\onJava\onjava-exp\test\bag\foo\bar\baz\File.txt
            Deleting :D:\study\onJava\onjava-exp\test\bar\baz\bag\foo\File.txt
            Deleting :D:\study\onJava\onjava-exp\test\baz\bag\foo\bar\File.txt
            Deleting :D:\study\onJava\onjava-exp\test\foo\bar\baz\bag\File.txt
            Deleting :D:\study\onJava\onjava-exp\test\Hello.txt
            event.context: Hello.txt
            event.count: 1
            event.kind: ENTRY_DELETE
        */
    }
}
