package com.jools.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 18:52
 * @description: TODO
 */
public class Resetting {

    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aui][gx]").matcher("fix the rug with bags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        /*
         输出:
            fix rug bag
            fix rig rag
        */
    }
}
