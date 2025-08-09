package com.jools.xiaohui.algorithm;

/**
 * @author Jools He
 * @date 2025/8/9 19:48
 * @description: TODO
 */
public class MinDiffAmongArray {

    public static void main(String[] args) {
        int[] array = {2, 6, 3, 4, 5, 10, 9};
        int maxDiff = getMaxSortedDistance(array);
        System.out.println("相邻元素差值最大为: " + maxDiff);
    }

    public static int getMaxSortedDistance(int[] array) {

        // 1. 计算得到数组内的最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int diff = max - min;
        if (diff == 0) {
            return 0;

        }

        // 2. 初始化桶, 桶的数量为 len;
        Bucket[] buckets = new Bucket[len];
        for (int i = 0; i < len; i++) {
            buckets[i] = new Bucket();
        }

        // 3. 遍历数组内的各个元素，确定各个桶内的最大和最小值
        for (int num : array) {
            /*
             确定下标, 每个桶的区间跨度为 (max - min) / (len - 1) = diff / len - 1
             当前选择桶的下标即为 num - 最小值 min 后再除以区间跨度后得到
             (num - min) / (diff / len - 1) = (num - min) * (len - 1) / diff
            */
            int idx = (num - min) * (len - 1) / diff;
            // 更新当前桶的最大最小值
            buckets[idx].min = Math.min(buckets[idx].min, num);
            buckets[idx].max = Math.max(buckets[idx].max, num);
        }

        // 4. 遍历桶，对于每个非空桶，计算当前桶的最大值和下一个桶最小值之间差值的最大值
        int maxDiff = buckets[0].max - buckets[0].min;
        // 上一个桶的最大值
        int preMax = buckets[0].max;
        for (int i = 1; i < len; i++) {
            if (buckets[i].min != Integer.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, buckets[i].min - preMax);
                preMax = buckets[i].max;
            }
        }
        return maxDiff;
    }
}

// 模拟桶
class Bucket {

    // 当前桶的最大值
    int min = Integer.MAX_VALUE;

    // 当前桶的最小值
    int max = Integer.MIN_VALUE;
}
