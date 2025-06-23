package com.jools.designpattern.chain_;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Jools He
 * @date 2025/6/22 22:43
 * @description: TODO
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        FindMinima solver = new FindMinima();
        List<Double> line = Arrays.asList(9.9, 8.8);
        Result res = solver.minima(line);

        if (res.success) {
            System.out.println(res.line);
        } else {
            System.out.println("No algorithm match");
        }
    }
}

interface Algorithm {
    Result algorithm(List<Double> line);
}

class FindMinima {

    // 测试方法
    public static Result test(boolean success, String id, double d1, double d2) {
        System.out.println(id);
        if (success) {  // 如果成功；计算
            return new Result(Arrays.asList(d1, d2));
        } else {    // 否则执行下一个策略
            return Result.FAIL;
        }
    }

    public static Result leastSquares(List<Double> line) {
        return test(false, "least squares", 1.1, 2.2);
    }

    public static Result perturbation(List<Double> line) {
        return test(true, "perturbation", 3.3, 4.4);
    }

    public static Result bisection(List<Double> line) {
        return test(false, "find minima", 5.5, 6.6);
    }

    // 注册各种方法
    static List<Function<List<Double>, Result>> algorithms = Arrays.asList(
            FindMinima::leastSquares,
            FindMinima::perturbation,
            FindMinima::bisection
    );

    // 遍历职责链; 如果处理成功则返回
    public static Result minima(List<Double> line) {
        for (Function<List<Double>, Result> alg : algorithms) {
            Result res = alg.apply(line);
            // 处理成功
            if (res.success) {
                return res;
            }
        }
        return Result.FAIL;
    }
}