package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 17:41
 * @description: TODO
 */
public class SwitchExpression {

    static int colon(String s) {
        // 使用新的 yield 关键字从 switch 中返回结果。使用 yield 的时候不需要用到 break
        return switch (s) {
            case "i":
                yield 1;
            case "j":
                yield 2;
            case "k":
                yield 3;
            default:
                yield 0;
        };
    }

    //
    static int arrow(String s) {
        return switch (s) {
            case "i" -> 1;
            case "j" -> 2;
            case "k" -> 3;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        for (String s : new String[]{"i", "j", "k", "z"}) {
            System.out.format("%s %d %d%n", s, colon(s), arrow(s));
        }
        /*
         输出结果:
            i 1 1
            j 2 2
            k 3 3
            z 0 0
        */
    }
}
