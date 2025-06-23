package com.jools.enum_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 16:50
 * @description: TODO
 */
public class RandomTest {

    public static void main(String[] args) {
        System.out.println("----- Enums.random(Class<T> cls) ----");
        for (int i = 0; i < 10; i++) {
            Activity select = Enums.random(Activity.class);
            System.out.println(select);
        }

        System.out.println("----- Enums.random(T[] vals) ----");
        for (int i = 0; i < 10; i++) {
            Activity select = Enums.random(Activity.values());
            System.out.println(select);
        }

        /*
         输出结果:
            ----- Enums.random(Class<T> cls) ----
            STATNDING
            LYING
            STATNDING
            SITTING
            SITTING
            STATNDING
            SITTING
            LYING
            STATNDING
            STATNDING
            ----- Enums.random(T[] vals) ----
            LYING
            RUNNING
            LYING
            SITTING
            SITTING
            STATNDING
            RUNNING
            SITTING
            RUNNING
            STATNDING
        */
    }
}

enum Activity {
    SITTING, LYING, STATNDING, RUNNING
}
