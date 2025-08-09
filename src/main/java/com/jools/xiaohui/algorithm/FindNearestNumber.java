package com.jools.xiaohui.algorithm;

import java.util.Arrays;

/**
 * @author Jools He
 * @date 2025/8/9 20:30
 * @description: TODO
 */
public class FindNearestNumber {

    public static void main(String[] args) {
        int num = 12345;
        // 连续输出 10 次全排列的数字，每次输出后，将 num 赋值为下一个全排列的数字
        for (int i = 0; i < 10; i++) {
            System.out.println(num);
            num = findNearestGreater(num);
        }
        /*
          输出结果:
            12345
            12354
            12435
            12453
            12534
            12543
            13245
            13254
            13425
            13452
        */
    }

    // 主体函数
    public static int findNearestGreater(int num) {
        int[] arr = new int[String.valueOf(num).length()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }

        // 1.查询逆序区间的首个坐标
        int preIdx = findReverseIdx(arr);
        if (preIdx == 0) {
            return -1;
        }

        int[] copyArr = Arrays.copyOf(arr, arr.length);
        // 交换逆序区域前一位的数字和逆序区域中大于该数字的最小数字
        exchangeHead(copyArr, preIdx);

        // 逆序区域内修改为正序
        reverse(copyArr, preIdx);

        // 转换为数字
        int ans = 0;
        for (int i = 0; i < copyArr.length; i++) {
            ans = ans * 10 + copyArr[i];
        }
        return ans;
    }

    //1. 找到逆序区域的前一个位置下标
    private static int findReverseIdx(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    //2. 找到逆序区域后面比逆序区域前一个位置大的最小元素下标
    private static int[] exchangeHead(int[] arr, int pre) {
        // 逆序区间的前一个数字
        int head = arr[pre - 1];
        // 从逆序区间后往前查询，遍历顺序为从小到达
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换首个最小的大于 head 的值
            if (head < arr[i]) {
                arr[pre - 1] = arr[i];
                arr[i] = head;
                break;
            }
        }
        return arr;
    }

    //3. 将逆序区域内的元素修改为升序
    private static void reverse(int[] arr, int pre) {
        int i = pre, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
