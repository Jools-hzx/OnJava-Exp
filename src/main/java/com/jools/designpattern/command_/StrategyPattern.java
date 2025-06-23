package com.jools.designpattern.command_;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Jools He
 * @date 2025/6/22 22:09
 * @description: TODO
 */

// 公共策略基类
class FindMinima {
    protected Function<List<Double>, List<Double>> algorithms;
}

// 各种具体策略
class LeastSquares extends FindMinima {
    public LeastSquares() {
        algorithms = (line) -> Arrays.asList(1.1, 2.2, 3.3);
    }
}

class Perturbation extends FindMinima {
    public Perturbation() {
        algorithms = (line) -> Arrays.asList(4.4, 5.5, 6.6);
    }
}

class Bisection extends FindMinima {
    public Bisection() {
        algorithms = (line) -> Arrays.asList(7.7, 8.8, 9.9);
    }
}

// 持有策略方法和上下文: 如何设置、更新具体策略
class MinimaSolver {

    // 抽象策略
    private FindMinima strategy;

    public MinimaSolver(FindMinima strategy) {
        // 设置具体策略
        this.strategy = strategy;
    }

    // 应用具体策略
    List<Double> minima(List<Double> line) {
        return strategy.algorithms.apply(line);
    }

    // 切换策略; 更新具体策略
    void changeAlgorithm(FindMinima newAlgorithm) {
        this.strategy = newAlgorithm;
    }
}

public class StrategyPattern {

    public static void main(String[] args) {
        MinimaSolver solver = new MinimaSolver(new LeastSquares());
        List<Double> line = Arrays.asList(1.0, 2.0, 1.0, 2.0, -1.0, 3.0, 4.0, 5.0);
        System.out.println(solver.minima(line));   // 采用 LeastSquares 策略

        // 更换策略
        solver.changeAlgorithm(new Perturbation());
        System.out.println(solver.minima(line));

        // 更换策略
        solver.changeAlgorithm(new Bisection());
        System.out.println(solver.minima(line));
    }
}
