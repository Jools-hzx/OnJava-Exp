package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:16
 * @description: TODO
 */
public class VideoCard extends Colleague{

    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("Your data is: " + data);
    }
}
