package com.jools.str;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 16:35
 * @description: TODO
 */
public class UsingStringBuilder {

    public static String str1() {
        Random random = new Random(47);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            sb.append(random.nextInt(100));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static String str2() {
        // 借助 Stream 流式 API，随机生成 25 个数字之后拼接
        String result = new Random(47).ints(25, 0, 100)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        System.out.println(str1());
        System.out.println(str2());
    }
}
