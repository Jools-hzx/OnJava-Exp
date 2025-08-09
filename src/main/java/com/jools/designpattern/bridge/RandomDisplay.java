package com.jools.designpattern.bridge;

import cn.hutool.core.util.RandomUtil;

/**
 * @author Jools He
 * @date 2025/7/27 12:36
 * @description: TODO
 */
public class RandomDisplay extends Display{

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        int bound = (int) RandomUtil.getRandom().nextInt(1, times);
        open();
        for (int i = 0; i < bound; i++) {
            print();
        }
        close();
    }
}
