package com.jools.designpattern.command_;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Jools He
 * @date 2025/6/22 22:23
 * @description: TODO
 */
public class StrategyPattern2 {

    public static void main(String[] args) {
        FindMinima2 solver = new FindMinima2();
        List<Double> line = Arrays.asList(
                4.4, 5.5, 6.6, 7.7
        );

        // 默认策略
        System.out.println(solver.minima(line));
        solver.perturbation();
        System.out.println(solver.minima(line));
        solver.bisection();
        System.out.println(solver.minima(line));
    }
}

class FindMinima2 {
    private Function<List<Double>, List<Double>> algorithms;

    public FindMinima2() {
        // 需要设置默认策略
        leastSquares();
    }

    // 各种策略
    void leastSquares() {
        algorithms = (l) -> Arrays.asList(1.1, 2.2);
    }

    void perturbation() {
        algorithms = (l) -> Arrays.asList(1.1, 2.2);
    }

    void bisection() {
        algorithms = (l) -> Arrays.asList(1.1, 2.2);
    }

    List<Double> minima(List<Double> line) {
        return algorithms.apply(line);
    }
}