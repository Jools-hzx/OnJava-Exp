package com.jools.io_;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Jools He
 * @date 2025/6/21 19:34
 * @description: TODO
 */
public class UsingBuffers {

    // 将 CharBuffer 中的字符两两进行反转
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);  // 反转
        System.out.println(cb.rewind());    // 输出: sUniBgfuefsr
        symmetricScramble(cb);  // 复原
        System.out.println(cb.rewind());    // 输出: UsingBuffers
    }
}
