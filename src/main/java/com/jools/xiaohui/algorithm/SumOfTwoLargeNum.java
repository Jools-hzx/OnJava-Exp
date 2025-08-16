package main.java.com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/10 15:17
 * @description: TODO
 */
public class SumOfTwoLargeNum {

    public static void main(String[] args) {
        System.out.println(sumBigNum("426709752318", "95481253129"));
    }

    public static String sumBigNum(String numA, String numB) {

        int len = Math.max(numA.length(), numB.length()) + 1;
        // 结果数组,存储各个位的累加结果
        int[] ans = new int[len + 1];
        // 分别遍历 numA,numB,之前累加之和是否超过10,ans当前位置下标
        int p1 = numA.length() - 1, p2 = numB.length() - 1, prev = 0, curr = len - 1;
        while(p1 >= 0 && p2 >= 0) {
            int a = numA.charAt(p1) - '0', b = numB.charAt(p2) - '0';
            int sum = a + b + prev; // 累加上进位的和
            prev = sum / 10;        // 是否需要进位
            ans[curr--] = sum % 10; // 当前和的个位数结果
            p1--;
            p2--;
        }

        // numA 还未遍历完
        while(p1 >= 0) {
            int sum = numA.charAt(p1--) + prev;
            prev = sum / 10;
            ans[curr--] = sum % 10;
        }
        // numB 还未遍历完
        while(p2 >= 0) {
            int sum = numA.charAt(p2--) + prev;
            prev = sum / 10;
            ans[curr--] = sum % 10;
        }

        // 构建结果
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while(p < len && ans[p] == 0) {
            p++;
        }
        while(p < len) {
            sb.append(ans[p++]);
        }
        return sb.toString();
    }
}
