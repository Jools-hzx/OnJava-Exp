package main.java.com.jools.pat.pingan;

import cn.hutool.bloomfilter.filter.FNVFilter;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/29 19:20
 * @description: TODO
 */
public class FindSubArr {

    static int[] arr1 = {1, 1, 1};
    static int[] arr2 = {1, 2, 3};

    public static void main(String[] args) {
        int cnt1 = findSubArr(arr1, 2);
        System.out.println(cnt1);

        int cnt2 = findSubArr(arr2, 3);
        System.out.println(cnt2);

    }

    public static int findSubArr(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = getSum(arr, i, j);
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int getSum(int[] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
