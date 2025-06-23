package com.jools.designpattern.template;

import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/22 14:21
 * @description: TODO
 */
public class TemplateMethod {

    public static void main(String[] args) {
        new MyApp();

        /*
         输出结果:
            customized1 0
            customized2 0
            customized1 1
            customized2 1
            customized1 2
            customized2 2
            customized1 3
            customized2 3
            customized1 4
            customized2 4
        */
    }
}

class MyApp extends ApplicationFramework {

    @Override
    void customize1(int n) {
        System.out.println("customized1 " + n);
    }

    @Override
    void customize2(int n) {
        System.out.println("customized2 " + n);
    }
}

abstract class ApplicationFramework {

    public ApplicationFramework() {
        templateMethod();   // 构造器调用模板方法
    }

    // 模板方法 01 - 待实现
    abstract void customize1(int n);

    // 模板方法 02 - 待实现
    abstract void customize2(int n);

    private void templateMethod() {
        IntStream.range(0, 5).forEach(
                n -> {
                    customize1(n);
                    customize2(n);
                }
        );
    }
}
