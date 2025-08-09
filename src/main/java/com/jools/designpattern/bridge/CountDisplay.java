package com.jools.designpattern.bridge;

/**
 * @author Jools He
 * @description: 在 Display 类的基础上增加了一些新的功能
 * Display 类只具有显示功能
 * CountDisplay 类则具有 "只显示规定的次数" 的功能
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
