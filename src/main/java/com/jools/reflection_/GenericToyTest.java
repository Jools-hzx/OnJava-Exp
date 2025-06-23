package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 22:13
 * @description: TODO
 */
public class GenericToyTest {

    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftCls = FancyToy.class;
        // 生成确切的类型
        FancyToy fancyToy = ftCls.getConstructor().newInstance();
        Class<? super FancyToy> upper = FancyToy.class.getSuperclass();
        // 如下代码无法通过编译
//        Class<Toy> upper2 = ftCls.getSuperclass();

        // 由于得到的 Class 对象不是确切的类型; 只能生成 Object;
        Object obj = upper.getConstructor().newInstance();
    }
}
