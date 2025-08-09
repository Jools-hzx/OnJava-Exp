package com.jools.designpattern.iterator;

public interface Iterator {

    /**
     * 是否存在下一个元素的 hasNext 方法
     * @return 存在下一个元素则返回 true
     */
    public abstract boolean hasNext();

    /**
     * 获取下一个元素的 next 方法; 隐含着将迭代器移动至下一个元素的处理
     * @return  存在则返回下一个元素；
     */
    public abstract Object next();
}
