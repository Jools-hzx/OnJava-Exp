package com.jools.io_;

import java.nio.ByteBuffer;

/**
 * @author Jools He
 * @date 2025/6/21 18:58
 * @description: TODO
 */
public class GetData {

    private static final int BSIE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIE);

        int i = 0;
        // limit(): 返回该 buffer 的大小限制
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println(bb.get());
            }
        }
        System.out.println("i= " + i);  // 输出: i = 1025
        bb.rewind();    // Rewinds this buffer. The position is set to zero and the mark is discarded.

        // 保存并读取 char 数组
        bb.asCharBuffer().put("Howdy!!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();

        // 保存并读取 short
        bb.asShortBuffer().put((short) 471142);
        System.out.println(bb.getShort());
        bb.rewind();

        // 保存并读取 int
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();

        // 保存并读取 long
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();

        // 保存并读取 float
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();

        // 保存并读取 double
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
