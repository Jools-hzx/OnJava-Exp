package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:17
 * @description: TODO
 */
public class SoundCard extends Colleague{

    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    // 按照声频数据发出声音
    public void soundData(String data) {
        System.out.println("Sound card data: " + data);
    }
}
