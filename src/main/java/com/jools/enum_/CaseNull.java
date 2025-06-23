package com.jools.enum_;

import java.util.function.Consumer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/1 17:14
 * @description: TODO
 */
public class CaseNull {

    // 旧版本仅支持在 switch 语句外部进行 null 判断
    static void old(String s) {
        if(s == null) {
            System.out.println("null");
            return;
        }
        switch(s) {
            case "XX" -> System.out.println("XX");
            default -> System.out.println("default");
        }
    }

    static void checkNull(String s) {
        switch(s) {
            case "XX" -> System.out.println("XX");
//            case null -> System.out.println("null");   //JDK 21 后支持
            default -> System.out.println("default");
        }
        // 使用冒号语法也支持
        switch(s) {
            case "XX":
                System.out.println("XX");
                break;
//            case null:
//                System.out.println("null");
//                break;
            default:
                System.out.println("default");
        }
    }

    static void defaultOnly(String s) {
        switch(s) {
            case "XX" -> System.out.println("XX");
            default -> System.out.println("default");
        }
    }

    static void combineNullAndCase(String s) {
        switch(s) {
//            case null, "XX" -> System.out.println("XX | null");  JDK 21 版本后支持
            default -> System.out.println("default");
        }
    }

    static void combineNullAndDefault(String s) {
        switch (s) {
            case "XX" -> System.out.println("XX");
//            case null, default -> System.out.println("default | null");  JDK 21 版本后支持
        }
    }

    static void test(Consumer<String> c) {
        c.accept("XX");
        c.accept("YY");
        try {
            c.accept(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        test(CaseNull::old);
        test(CaseNull::checkNull);
        test(CaseNull::defaultOnly);
        test(CaseNull::combineNullAndCase);
        test(CaseNull::combineNullAndDefault);
    }
}
