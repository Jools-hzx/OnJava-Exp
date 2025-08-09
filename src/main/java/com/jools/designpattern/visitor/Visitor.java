package com.jools.designpattern.visitor;

/**
 * @author Jools He
 * @description: 访问者抽象类
 * 程序会根据接收的参数的类型不同
 * 自动选择和执行相应的 visit 方法，称为 ⌈ 重载 ⌋
 */
public abstract class Visitor {

    public abstract void visit(File file);

    public abstract void visit(Directory dir);
}
