package com.jools.designpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/7/28 13:14
 * @description: TODO
 */
public class FileFindVisitor extends Visitor {

    // 结果
    private List<File> results;

    // 当前文件目录路径
    private String currentDir;

    // 搜索目标后缀
    private String suffix;

    public FileFindVisitor(String suffix) {
        this.currentDir = "";
        this.results = new ArrayList<>();
        this.suffix = suffix;
    }

    public Iterator<File> getFoundFiles() {
        return results.iterator();
    }

    @Override
    public void visit(File file) {
        if(file.getName().endsWith(suffix)) {
            results.add(file);
        }
    }

    @Override
    public void visit(Directory dir) {
        System.out.println(currentDir + "/" + dir);
        String saveDir = currentDir;
        // 遍历当前目录
        currentDir = currentDir + "/" + dir.getName();
        Iterator<Entry> iter = dir.iterator();
        while (iter.hasNext()) {
            Entry entry = iter.next();
            entry.accept(this);
        }
        // 更新;将当前目录作为其子目录的前缀
        currentDir = saveDir;
    }
}
