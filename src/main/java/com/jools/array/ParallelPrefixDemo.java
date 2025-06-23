package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 21:29
 * @description: TODO
 */
public class ParallelPrefixDemo {

    public static void main(String[] args) {

        int[] nums = new RandGen
                .Pint()
                .array(10);
        ArrayShow.show(nums);

        // 在位置 0，将前置位置算好的值和当前值合并，更新到位置 0；依次类推
        System.out.println(
                Arrays.stream(nums)
                        .reduce(Integer::sum)
                        .getAsInt());

        //Stream.reduce() 方法只能得到最终的结果；
        //而 Arrays.parallelPrefix() 则还能得到所有中间结果只
        Arrays.parallelPrefix(nums, Integer::sum);

        ArrayShow.show(nums);
        System.out.println(Arrays.stream(new RandGen.Pint().array(6))
                .reduce(Integer::sum)
                .getAsInt());
        /*
         输出: Stream.reduce() 的计算结果已经存在于 parallelPrefix 中
            [635, 9372, 13313, 18033, 24210, 32689, 39345, 43113, 48061, 54254]
            32689
        */
    }
}
