package com.jools.collections_;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 16:21
 * @description: TODO
 */
public class FillingLists {

    public static void main(String[] args) {
        ArrayList<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);
        /*
         输出结果:
          [StringAddress->Hello, StringAddress->Hello, StringAddress->Hello, StringAddress->Hello]
        */

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
        /*
         输出结果:
          [StringAddress->World!, StringAddress->World!, StringAddress->World!, StringAddress->World!]
        */
    }
}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + "->" + s;
    }
}

