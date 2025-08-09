package com.jools.designpattern.visitor;

/**
 * 接受访问者的访问接口
 */
public interface Element {

    // 参数就是 Visitor
    void accept(Visitor v);
}
