package com.jools.designpattern.flyweight.template;

public interface Flyweight {

    /**
     * 示例操作，传入外部对象
     * @param extrinsicState 示例参数，外部状态
     */
    void operate(String extrinsicState);
}
