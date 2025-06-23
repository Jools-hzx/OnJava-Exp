package com.jools.designpattern.observer;

import org.junit.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/18 17:27
 * @description: TODO
 */
public class Main {

    @Test
    public void testIncremental() {
        NumberGenerator incrementalGenerator = new IncrementalNumberGenerator(10, 100, 20);

        // 创建监听者
        DigitObserver digitObserver = new DigitObserver();
        GraphObserver graphObserver = new GraphObserver();

        //注册监听者
        incrementalGenerator.add(digitObserver);
        incrementalGenerator.add(graphObserver);

        incrementalGenerator.execute();

        /*
        DigitObserver:10
        GraphObserver:
         ====
        ****************************** =====
        DigitObserver:30
        GraphObserver:
         ====
        ***********************************************....
        DigitObserver:50
        GraphObserver:
         ====
        ***********************************....
        DigitObserver:70
        GraphObserver:
         ====
        ********************************....
        DigitObserver:90
        GraphObserver:
         ====
        ***********************....
         */
    }

    public static void main(String[] args) {

        NumberGenerator randomGenerator = new RandomNumberGenerator();

        // 创建监听者
        DigitObserver digitObserver = new DigitObserver();
        GraphObserver graphObserver = new GraphObserver();
        // 新增监听者
        DotObserver dotObserver = new DotObserver();

        // 注册监听者
        randomGenerator.add(digitObserver);
        randomGenerator.add(graphObserver);
        randomGenerator.add(dotObserver);

        randomGenerator.execute();

        /*
            DigitObserver:17
            GraphObserver:
             ====
            ***************************************************
            =======
            DotObserver:
            ====
            . 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	.
            ========
            DigitObserver:15
            GraphObserver:
             ====
            *********************************************
            =======
            DotObserver:
            ====
            . 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	.
            ========
            DigitObserver:18
            GraphObserver:
             ====
            ******************************************************
            =======
            DotObserver:
            ====
            . 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	. 	.
            ========
            DigitObserver:1
            GraphObserver:
             ====
            ***
            =======
            DotObserver:
            ====
            .
            ========
            DigitObserver:4
            GraphObserver:
             ====
            ************
            =======
            DotObserver:
            ====
            . 	. 	. 	.
            ========
         */
    }
}
