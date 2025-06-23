package com.jools.designpattern.factory;

import java.util.function.Supplier;

/**
 * @author Jools He
 * @date 2025/6/22 21:21
 * @description: TODO
 */
public class GameEnvironment {

    private Player p;
    private Obstacle ob;

    // 通过具体工厂获取玩家和障碍物
    public GameEnvironment(GameElementFactory factory) {
        p = factory.player.get();
        ob = factory.obstacle.get();
    }

    public void play() {
        p.interactWith(ob);
    }

    public static void main(String[] args) {
        GameEnvironment ge = new GameEnvironment(new KittiesAndPuzzles());
        ge.play();
        ge = new GameEnvironment(new Melee());
        ge.play();
        /*
         输出结果:
            Kitty has encountered a
            Puzzle
            Fighter has encountered a
            Weapon
        */
    }
}

class GameElementFactory {
    Supplier<Player> player;
    Supplier<Obstacle> obstacle;
}

class KittiesAndPuzzles extends GameElementFactory {

    KittiesAndPuzzles() {
        player = Kitty::new;
        obstacle = Puzzle::new;
    }
}

class Melee extends GameElementFactory {
    Melee() {
        player = Fighter::new;
        obstacle = Weapon::new;
    }
}

interface Obstacle {
    void action();
}

interface Player {
    void interactWith(Obstacle o);
}

class Kitty implements Player {

    @Override
    public void interactWith(Obstacle o) {
        System.out.println("Kitty has encountered a ");
        o.action();
    }
}

class Fighter implements Player {

    @Override
    public void interactWith(Obstacle o) {
        System.out.println("Fighter has encountered a ");
        o.action();
    }
}

class Puzzle implements Obstacle {

    @Override
    public void action() {
        System.out.println("Puzzle");
    }
}

class Weapon implements Obstacle {
    @Override
    public void action() {
        System.out.println("Weapon");
    }
}
