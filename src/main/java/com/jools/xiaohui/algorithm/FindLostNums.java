package main.java.com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/10 17:05
 * @description: TODO
 */
public class FindLostNums {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 2, 5, 1, 4, 3};
        int[] lostNums = findLostNums(arr);
        System.out.print(lostNums[0] + " ");
        System.out.println(lostNums[1]);  // 输出 5 3
    }

    private static int[] findLostNums(int[] arr) {
        // 计算首轮异或结果
        int xor = 0;
        for (int j : arr) {
            xor ^= j;
        }
        // 如果异或结果为 0, 则说明输入的数组不符合题目要求
        if (xor == 0) {
            return new int[2];
        }
        // 确定两个出现奇数次的数字的不同数位
        int separator = 1;
        while (0 == (xor & separator)) {
            separator <<= 1;
        }
        // 第 2 次分许进行异或运算
        int[] ans = new int[2];
        for (int i : arr) {
            // 第一个分组
            if (0 == (i & separator)) {
                ans[0] ^= i;
            } else {
                // 第二分组
                ans[1] ^= i;
            }
        }
        // 最终异或得到的两个数字
        return ans;
    }
}
