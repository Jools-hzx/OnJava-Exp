package com.jools.designpattern.flyweight.security;

/**
 * 描述授权数据的享元接口
 */
public interface Flyweight {

    boolean match(String securityEntity, String permit);
}
