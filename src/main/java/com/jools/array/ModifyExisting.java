package com.jools.array;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/25 18:42
 * @description: TODO
 */
public class ModifyExisting {

    public static void main(String[] args) {

        int[] da = new int[7];
        Arrays.setAll(da, new RandGen.Integer()::get);
        ArrayShow.show(da);     // 输出: [635, 8737, 3941, 4720, 6177, 8479, 6656]

        // 修改，基于 IntUnaryOperator 函数式接口
        Arrays.setAll(da, n -> da[n] / 100);
        ArrayShow.show(da);     // 输出: [6, 87, 39, 47, 61, 84, 66]
    }
}
