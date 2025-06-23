package com.jools.io_;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Jools He
 * @date 2025/6/21 19:09
 * @description: TODO
 */
public class IntBufferDemo {

    private static final int BSZIE = 1024;

    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocate(BSZIE);
        IntBuffer ib = bb.asIntBuffer();
        // 批量插入
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});

        // 通过绝对地址写入
        System.out.println(ib.get(3));  // 9
        ib.put(3, 1811);

        // 回退前刷新
        // filp():
        //   Flips this buffer. The limit is set to the current position and then the position is set to zero.
        //   If the mark is defined then it is discarded.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.print(i + ", ");
        }

        /*
          输出: 11, 42, 47, 1811, 143, 811, 1016,
        */
    }
}
