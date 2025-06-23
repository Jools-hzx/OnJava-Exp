package com.jools.assertion;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 21:39
 * @description: TODO
 */
public class LoaderAssertions {
    public static void main(String[] args) {

        // 借助 setDefaultAssertionStatus() 方式为它之后加载的所有类设置了断言状态
        ClassLoader.getSystemClassLoader()
                .setDefaultAssertionStatus(false);
        new Loaded().go();
        /*
         1. 当 setDefaultAssertionStatus(true)输出:
         Exception in thread "main" java.lang.AssertionError: Loaded.go()
	        at com.jools.assertion.Loaded.go(LoaderAssertions.java:21)
	        at com.jools.assertion.LoaderAssertions.main(LoaderAssertions.java:15)

        2. 当 setDefaultAssertionStatus(false) 输出:
        */
    }
}

class Loaded {
    public void go() {
        assert false : "Loaded.go()";
    }
}
