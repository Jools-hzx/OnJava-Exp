package com.jools.validating;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/6 16:39
 * @description: TODO
 */
public class DynamicStringInverterTests {

    // 生成 DynamicTest 对象的流 (通过 testVersions() 方法)
    Stream<DynamicTest> testVersions(String id, Function<StringInverter, String> test) {
        List<StringInverter> versions = Arrays.asList(new Inverter1(), new Inverter2(), new Inverter3(), new Inverter4());
        return DynamicTest.stream(
                versions.iterator(),
                inverter -> inverter.getClass().getSimpleName(),
                inverter -> {
                    System.out.println(inverter.getClass().getSimpleName() + ": " + id);
                    try {
                        if (!Objects.equals(test.apply(inverter), "fail")) {
                            System.out.println("Success");
                        }
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
        );
    }

    // 辅助方法，判断两个字符串是否相等
    String isEqual(String lval, String rval) {
        if (lval.equals(rval)) {
            return "success";
        }
        System.out.println("FAIL:" + lval + " != " + rval);
        return "fail";
    }

    @BeforeAll
    static void startMsg() {
        System.out.println(">>> Starting DynamicStringInverterTests <<<");
    }

    @AfterAll
    static void endMsg() {
        System.out.println(">>> Finished DynamicStringInverterTests <<<");
    }

    @TestFactory
    Stream<DynamicTest> basicInversion1() {
        String in = "Exit, Pursued by a Bera";
        String out = "eXIT, pURSUED BY A bERA";
        return testVersions(
                "Basic inversion (should be succeed)",
                inverter -> isEqual(inverter.invert(in), out));
    }

    @TestFactory
    Stream<DynamicTest> basicInversion2() {
        return testVersions(
                "Basic inversion (should be failed)",
                inverter -> isEqual(inverter.invert("X"), "X"));
    }

    @TestFactory
    Stream<DynamicTest> disallowCharacters() {
        String disallowed = ";-_()*&^%#@!~~`0123456789";
        return testVersions(
                "Disallow characters",
                inverter -> {
                    String result = disallowed.chars().mapToObj(c -> {
                        String cc = Character.toString((char) c);
                        try {
                            inverter.invert(cc);
                            return "";
                        } catch (RuntimeException e) {
                            return cc;
                        }
                    }).collect(Collectors.joining(""));
                    if (result.isEmpty()) {
                        return "success";
                    }
                    System.out.println("bad characters:" + result);
                    return "fail";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> allowedCharacters() {
        String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
        String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
        return testVersions(
                "Allow Character (shoubld be succeed)",
                inverter -> {
                    Assertions.assertEquals(inverter.invert(lowcase), upcase, lowcase);
                    Assertions.assertEquals(inverter.invert(upcase), lowcase, upcase);
                    return "success";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthNoGreaterThan30() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() > 30);
        return testVersions(
                "String length must be less than 31 (should throw exception)",
                inverter -> inverter.invert(str)
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthLessThan31() {
        String str = "XXXXXXXXXXXXX";
        assertTrue(str.length() <= 30);
        return testVersions(
                "String length must be less than 31 (should be succeed)",
                inverter -> inverter.invert(str)
        );
    }
}

interface StringInverter {
    String invert(String input);
}

// 没有任何功能的实现类
class Inverter1 implements StringInverter {

    @Override
    public String invert(String input) {
        return input;
    }
}

// 实现翻转操作
class Inverter2 implements StringInverter {

    @Override
    public String invert(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            result += Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        return result;
    }
}

// 实现翻转；确保添加的字符串长度不超过 30
class Inverter3 implements StringInverter {

    @Override
    public String invert(String input) {
        if (input.length() > 30) {
            throw new RuntimeException("argument too long!!!");
        }
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            result += Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        return result;
    }
}

// 实现翻转操作；长度不超过 30；且存在白名单
class Inverter4 implements StringInverter {

    static final String ALLOWED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";

    @Override
    public String invert(String input) {
        if (input.length() > 30) {
            throw new RuntimeException("argument too long!!!");
        }
        String result = "";
        for (char c : input.toCharArray()) {
            if (ALLOWED.indexOf(c) == -1) {
                throw new RuntimeException("argument contains illegal character!!!");
            }
            result += Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        return result;
    }
}
