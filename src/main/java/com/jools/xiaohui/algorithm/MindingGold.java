package main.java.com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/10 16:06
 * @description: TODO
 */
public class MindingGold {

    public static void main(String[] args) {
        int w = 10;  // 总人数
        int[] p = {5, 5, 3, 4, 3};  // 每座金矿开采所需的人数
        int[] g = {400, 500, 200, 300, 350};    // 每座金矿可以开采出来的黄金总量

        int max_1 = getBestGoldMiningV2(w, p, g);
        System.out.println("最大利润: " + max_1); // 900

        int max_2 = getBestGoldMiningWithOneDimensionArr(w, p, g);
        assert max_1 == max_2;
        System.out.println("最大利润: " + max_2);
    }

    public static int getBestGoldMiningWithOneDimensionArr(int w, int[] p, int[] g) {
        // 创建一维数组, dp[i] 表示可用人数 1 ~ i 可以挖掘得到的最大金矿价值
        int[] dp = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            // 防止覆盖,从最大人数开始
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    dp[j] = Math.max(
                            dp[j],                          // 不开采当前第 i 座金矿
                            dp[j - p[i - 1]] + g[i - 1]     // 开采第 i - 1 座金矿，累加金矿 g[i]
                    );
                }
            }
        }
        // 返回可用人数 w 时可开采的最大子
        return dp[w];
    }

    public static int getBestGoldMiningV2(int w, int[] p, int[] g) {
        // 创建表格 dp[i][j] 表示 可开采金矿范围: 第 1 ~ i - 1 座 和可使用总人数 1 ~ j - 1 总人数
        int[][] dp = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    // 小于开采第 i 个金矿所需的人数,则无法开采
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],   // 不开采
                            dp[i - 1][j - p[i - 1]] + g[i - 1]  // 进行开采，黄金数量增加 g[i - 1]
                    );
                }
            }
        }
        // 返回最后一个格子的结果: 表示可选开采所有金矿，并且可用人数达到最大值
        return dp[g.length][w];
    }
}
