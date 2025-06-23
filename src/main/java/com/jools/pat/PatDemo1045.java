package com.jools.pat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/27 17:07
 * @description: TODO
 */
public class PatDemo1045 {

}

/*
  基于输入的顺序 [2 3 1 5 6] 获取的结果也要按照其相对顺序返回结果
  输入格式:
  1. 第一行: N 表示出现不同颜色的总个数
  2. 第二行: M 个正整数，表示 Eva 最喜欢的颜色及其顺序 target
  3. 第三行: L 个正整数，表示所有颜色的序列   colors

  输出要求: Eva favorite stripe 的最长长度
  数组 String[] target 按照顺序记录选取的目标颜色
  数组 boolean[] selected 标记 target 内下标为 i 的颜色是否被选取
  可以选取当前元素 colors[i] 则满足:
  1. 当前元素之前的颜色 select[i - 1] 已经被选取过
  2. 如果 select[i - 1] = false; 说明还未按顺序取前一个元素；则跳过

  StringBuilder 接收所有可能的结果；
  int maxLen 接收最大的长度
*/


class Main {

    // 记录最长结果长度
    static int maxLen = Integer.MIN_VALUE;

    // 记录所有结果
    static List<String> group = new ArrayList();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // 表示不同颜色的总个数
        int N = Integer.parseInt(s.nextLine());
        String[] line2 = s.nextLine().split("\\s+");

        // 喜欢的颜色
        int M = Integer.parseInt(line2[0]);

        // 检查输入
        if (M < 1) {
            System.out.println(0);
            return;
        }

        // 喜欢的颜色，按照顺序
        List<String> target = new ArrayList<>();
        boolean[] selected = new boolean[M];
        for (int i = 1; i <= M; i++) {
            target.add(line2[i]);
        }
        System.out.println("Favor:" + target);
        System.out.println("Selected:" + Arrays.toString(selected));

        // 所有颜色序列
        String[] line3 = s.nextLine().split("\\s+");
        int L = Integer.parseInt(line3[0]);
        String[] colors = new String[L];

        for (int i = 1; i <= L; i++) {
            colors[i - 1] = line3[i];
        }
        System.out.println("所有颜色:" + Arrays.toString(colors));

        // 深搜(撤销回溯)
        dfs(target, selected, colors, 0, -1);

        System.out.println(maxLen);
    }

    private static void dfs(List<String> favor, boolean[] selected,
                            String[] colors, int startIdx, int preSelectIdx) {
        if (startIdx >= colors.length) {
            maxLen = Math.max(maxLen, group.size());
            return;
        }
        for (int i = startIdx; i < colors.length; i++) {
            String curr = colors[i];                // 当前颜色
            int currSelected = Math.max(favor.indexOf(curr), 0);     // 当前颜色所处喜爱颜色的下标
            if (currSelected - preSelectIdx != 1) {
                continue;
            }
            if (preSelectIdx < 0 || selected[preSelectIdx]) {
                group.add(curr);
                // 首次选取到未选过的喜爱颜色
                if (!selected[currSelected]) {
                    selected[currSelected] = true;
                    preSelectIdx = currSelected;
                }
                // 进入下一层递归
                dfs(favor, selected, colors, i + 1, preSelectIdx);
                group.remove(group.size() - 1);
                // 如果已经撤销了所有 curr 颜色，则将其标记为未选取
                if (!group.contains(curr)) {
                    selected[currSelected] = false;
                    preSelectIdx = currSelected - 1;
                }
            }
        }
    }
}
