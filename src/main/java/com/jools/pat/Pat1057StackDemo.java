package com.jools.pat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/6 20:02
 * @description: TODO
 */
public class Pat1057StackDemo {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 初始化栈
        List<String> stack = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split("\\s+");
            String oper = input[0];
            String res;

            switch (oper) {
                case "Pop":
                    if (stack.isEmpty()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    res = stack.remove(0);
                    System.out.println(res);
                    break;
                case "Push":
                    if (stack.size() == N) {
                        System.out.println("Invalid");
                        continue;
                    }
                    String e = input[1];
                    stack.add(0, e);
                    break;
                case "PeekMedian":
                    if (stack.isEmpty()) {
                        System.out.println("Invalid");
                        break;
                    }
                    int size = stack.size();
                    if(size < 2) {
                        System.out.println(stack.get(0));
                        break;
                    }
                    List<String> tmp = new ArrayList<>(stack);
                    Collections.sort(tmp);
                    if (size % 2 == 0) {
                        System.out.println(tmp.get(size / 2 - 1));
                    } else {
                        System.out.println(tmp.get((size + 1) / 2 - 1));
                    }
                    break;
                default:
                    throw new RuntimeException("Unsupported operation!");
            }
        }
    }
}