package com.jools.designpattern.strategy.hand;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/3 16:11
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

        int seed01 = 1;
        int seed02 = 3;

        Player player01 = new Player("AAAA", new RandomStrategy(seed01));
        Player player02 = new Player("BBBB", new ProbStrategy(seed02));

        for (int i = 0; i < 10; i++) {
            Hand nextHand01 = player01.nextHand();
            Hand nextHand02 = player02.nextHand();
            if (nextHand01.isStrongerThan(nextHand02)) {
                System.out.println("Winner is:" + player01.getName());
                player01.win();
                player02.lose();
            } else if (nextHand02.isStrongerThan(nextHand01)) {
                System.out.println("Winner is:" + player02.getName());
                player02.win();
                player01.lose();
            } else {
                System.out.println("Even");
                player01.even();
                player02.even();
            }
        }

        System.out.println("Total:");
        System.out.println(player01);
        System.out.println(player02);

        /*
         输出:
            Winner is:BBBB
            Winner is:AAAA
            Winner is:BBBB
            Winner is:BBBB
            Winner is:AAAA
            Winner is:AAAA
            Even
            Even
            Even
            Even
            Total:
            Player - [name='AAAA', strategy=RandomStrategy, winCount=3, loseCount=3, gameCount=10]
            Player - [name='BBBB', strategy=ProbStrategy, winCount=3, loseCount=3, gameCount=10]
         */
    }
}
