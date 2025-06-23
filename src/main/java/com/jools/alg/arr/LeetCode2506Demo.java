package com.jools.alg.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/22 21:14
 * @description: TODO
 */
public class LeetCode2506Demo {

    public static void main(String[] args) {
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(new LeetCode2506Demo().new Solution().similarPairs(words));
    }

    class Solution {

        public int similarPairs(String[] words) {
            Set<int[]> mapper = new HashSet<>();
            int cnt = 0; // 相似的对数
            for (String s : words) {
                int[] charCnt = getCharCnt(s);
                if (mapper.contains(charCnt)) { // 存在相同字符组成
                    cnt++;
                    mapper.remove(charCnt);
                }
                mapper.add(charCnt);
            }
            return cnt;
        }

        private int[] getCharCnt(String input) {
            int[] charCnt = new int[26];
            for (char c : input.toCharArray()) {
                // 下标 i 不为 0 则表示该字符出现过
                int charIdx = c - 'a';
                if (charCnt[charIdx] == 0) {
                    charCnt[charIdx]++;
                }
            }
            return charCnt;
        }
    }
}
