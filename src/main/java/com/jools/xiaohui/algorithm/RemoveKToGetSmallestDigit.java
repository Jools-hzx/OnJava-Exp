package main.java.com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/10 14:19
 * @description: TODO
 */
public class RemoveKToGetSmallestDigit {

    public static void main(String[] args) {
        System.out.println(removeKDigitWithStack("1593212", 3));
        System.out.println(removeKDigitWithStack("30200", 1));
        System.out.println(removeKDigitWithStack("10", 2));
        System.out.println(removeKDigitWithStack("541270936", 3));
    }

    public static String removeKDigitWithStack(String num, int k) {
        int len = num.length();
        if (len == 0) {
            return "0";
        }
        int newLen = len - k;   // 剔除之后减少 k 位数字
        char[] stack = new char[num.length()];
        int top = 0;
        stack[top] = num.charAt(0);
        for (int i = 0; i < len; i++) {
            // 遍历当前数字
            char c = num.charAt(i);
            // 当前数字大于其右侧数字;需要从 stack 内删除,将 top 指向 stack 内的前一个元素
            while (top > 0 && num.charAt(i) < stack[top - 1] && k > 0) {
                k--;
                top -= 1;
            }
            // 更新或记录字符
            stack[top++] = c;
        }
        // 剔除前导零构建新整数
        int p = 0;
        while (p <= newLen && stack[p] == '0') {
            p++;
        }
        // 如果全为前导零,则返回"0"; 否则返回新字符串为位置 p 到后续 newLen - p 个字符
        return p >= top ? "0" : new String(stack, p, newLen - p);
    }

    /**
     * 删除整数的 k 个数字，获得删除之后的最小整数
     *
     * @param num 整数字符串
     * @param k   剔除操作 k 次
     * @return 返回剔除操作完成后的最小整数字符串
     */
    public static String removeKDigits(String num, int k) {
        // 删除次数 k 次
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            // 每轮删除之后需要重新确定字符串的长度
            int len = num.length();
            for (int j = 0; j < len - 1; j++) {
                // 查询第一个大于右侧的下标
                char c1 = num.charAt(j), c2 = num.charAt(j + 1);
                if (c1 > c2) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    hasCut = true;
                    break;
                }
            }
            // 如果没有中间可分割点,则剔除最后一位的数字
            if (!hasCut && !num.isEmpty()) {
                num = num.substring(0, num.length() - 1);
            }
            // 清楚前导0
            num = removeZero(num);
        }
        // 如果所有字符都被删除，返回 0
        if (num.isEmpty()) {
            return "0";
        }
        return num;
    }

    private static String removeZero(String num) {
        int p = 0;
        int len = num.length();
        while (p < len && num.charAt(p) == '0') {
            p++;
        }
        return num.substring(p, len);
    }
}
