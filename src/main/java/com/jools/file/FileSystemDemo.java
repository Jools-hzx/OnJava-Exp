package com.jools.file;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/7 19:34
 * @description: TODO
 */
public class FileSystemDemo {

    static void show(String id, Object o) {
        System.out.println(id + ": " + o);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        FileSystem fileSystem = FileSystems.getDefault();
        // 输出磁盘分区信息
        for (FileStore fs : fileSystem.getFileStores()) {
            show("File Store", fs);
        }
        // 输出磁盘根目录信息
        for (Path rd : fileSystem.getRootDirectories()) {
            show("Root Dir", rd);
        }
        //分割
        show("Separator", fileSystem.getSeparator());
        show("UserPrincipalLookupService", fileSystem.getUserPrincipalLookupService());
        show("isOpen", fileSystem.isOpen());
        show("isReadOnly", fileSystem.isReadOnly());
        show("FileSystemProvider", fileSystem.provider());
        // 输出文件属性视图
        show("File Attribute Views", fileSystem.supportedFileAttributeViews());

        /*
         输出:
            Windows 11
            File Store: Windows-SSD (C:)
            File Store: Data (D:)
            File Store: (E:)
            Root Dir: C:\
            Root Dir: D:\
            Root Dir: E:\
            Root Dir: G:\
            Separator: \
            UserPrincipalLookupService: sun.nio.fs.WindowsFileSystem$LookupService$1@2e5d6d97
            isOpen: true
            isReadOnly: false
            FileSystemProvider: sun.nio.fs.WindowsFileSystemProvider@238e0d81
            File Attribute Views: [owner, dos, acl, basic, user]
        */
    }
}
