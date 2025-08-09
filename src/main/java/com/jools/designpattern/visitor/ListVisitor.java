package com.jools.designpattern.visitor;

import java.util.Iterator;

/**
 * @author Jools He
 * @description: 作用是返回数据结果并且显示元素一览
 * Visitor 子类实现 visit(File) 方法和 visit(Directory)
 * 处理流程: 先显示当前文件夹的名字，然后显示间隔符号 "/", 最后显示文件名
 * 构建递归调用: accept 方法与 visit 方法之间相互递归调用
 */
public class ListVisitor extends Visitor {

    private String currentDir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
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
