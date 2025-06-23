package com.jools.enum_;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 17:53
 * @description: TODO
 */
public enum ConstantSpecificMethod {

    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("PATH");
        }
    },

    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {

        ConstantSpecificMethod[] values = values();
        for (ConstantSpecificMethod m : values) {
            System.out.println(m.getInfo());
        }

        /*
         输出:
            2025年4月26日
            D:\Maven_installed\apache-maven-3.6.3\bin;.....
            17.0.13
        */
    }
}
