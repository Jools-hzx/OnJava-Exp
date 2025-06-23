package com.jools.designpattern.template;

/**
 * @author Jools He
 * @date 2025/6/22 15:35
 * @description: TODO
 */
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next = br.readLine().trim();
        CoffeeMachine maker;

        do {
            switch (next) {
                case "1":
                    maker = new American();
                    break;
                case "2":
                    maker = new Latte();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown coffee type");
            }
            maker.cookCoffee();
            next = br.readLine();
        } while (null != next && !next.isEmpty());
    }
}

// 抽象咖啡制造机器
abstract class CoffeeMachine {


    private void grind() {
        System.out.println("Grinding coffee beans");
    }

    // 抽象方法: 添加调料
    protected abstract void addCondiments();

    private void brew() {
        System.out.println("Brewing coffee");
    }

    public void cookCoffee() {
        grind();
        addCondiments();
        brew();
    }
}

// 实现: 美式咖啡
class American extends CoffeeMachine {

    private static final PrintWriter OUT = new PrintWriter(System.out);

    @Override
    public void addCondiments() {
        OUT.println("Adding condiments");
    }
}

// 实现: 拿铁咖啡
class Latte extends CoffeeMachine {

    @Override
    public void addCondiments() {
        System.out.println("Adding milk");
        System.out.println("Adding condiments");
    }
}












