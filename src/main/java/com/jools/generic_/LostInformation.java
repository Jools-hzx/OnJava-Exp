package com.jools.generic_;

import cn.hutool.core.lang.hash.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 16:49
 * @description: TODO
 */
public class LostInformation {

    public static void main(String[] args) {
        ArrayList<Frob> list = new ArrayList<>();
        HashMap<Frob, Fnorkle> hashMap = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();

        System.out.println(Arrays.toString(
                list.getClass().getTypeParameters()     // 输出结果: [E]
        ));
        System.out.println(Arrays.toString(
                hashMap.getClass().getTypeParameters()  // 输出结果: [K, V]
        ));
        System.out.println(Arrays.toString(
                quark.getClass().getTypeParameters()    // 输出结果: [Q]
        ));
        System.out.println(Arrays.toString(
                p.getClass().getTypeParameters()    // 输出结果: [POSITION, MOMENTUM]
        ));
    }
}

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}
