package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 16:16
 * @description: TODO
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
    }

    @Override
    public String toString() {
        return "The traffic light now is: " + this.color + " ~~~";
    }

    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(light);
            light.change();
        }

        /*
         输出结果:
            The traffic light now is: RED ~~~
            The traffic light now is: GREEN ~~~
            The traffic light now is: YELLOW ~~~
            The traffic light now is: RED ~~~
            The traffic light now is: GREEN ~~~
            The traffic light now is: YELLOW ~~~
            The traffic light now is: RED ~~~
        */
    }
}

enum Signal {
    GREEN, YELLOW, RED
}


