package com.jools.enum_;

import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 16:36
 * @description: TODO
 */
public class EnumImplementation {

    public static <T> void printNext(Supplier<T> supplier) {
        System.out.println(supplier.get() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter bob = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            // CartoonCharacter 枚举类实现了 Supplier 接口
            printNext(bob);
        }
    }
}

enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    @Override
    public CartoonCharacter get() {
        // 随机返回一个 CartoonCharacter 实例; values 返回的是枚举类的数组
        return values()[(int) (Math.random() * values().length)];
    }

}

