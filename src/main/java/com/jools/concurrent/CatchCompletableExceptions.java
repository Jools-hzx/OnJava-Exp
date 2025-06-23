package com.jools.concurrent;

/**
 * @author Jools He
 * @date 2025/6/19 19:43
 * @description: TODO
 */
public class CatchCompletableExceptions {

    static void handleException(int failCount) {

        // 只在有异常的时候才会调用该函数，必须生产和输出相同的类型;
        CompletableExceptions
                .test("exceptionally", failCount)
                .exceptionally(ex -> {      // Function
                            if (ex == null) {
                                System.out.println("Not yet!");
                            }
                            return new Breakable(ex.getMessage(), 0);
                        }
                        // thenAccept 消费入参也为 Breakable
                ).thenAccept(s -> System.out.println("result: " + s));


        // 有异常则创建新结果
        CompletableExceptions
                .test("handle", failCount)
                .handle((result, fail) -> {
                    if (fail != null) {
                        return "Failure recovery obj";
                    } else {
                        return result + " is good";
                    }
                }).thenAccept(s -> System.out.println("result: " + s));

        // 做了一些逻辑，但是仍然向下传递相同的结果
        CompletableExceptions
                .test("whenComplete", failCount)
                .whenComplete((result, fail) -> {
                    if (fail != null) {
                        System.out.println("It failed....");
                    } else {
                        System.out.println(result + " OK");
                    }
                }).thenAccept(s -> System.out.println("result: " + s));
    }

    public static void main(String[] args) {

        System.out.println("---- 失败测试 ----");
        handleException(2);

        /*
         输出结果:
            Breakable{failCount=1}
            Throwing Exception for exceptionally
            result: Breakable{failCount=0} // exceptionally(): 生成和输入相同的类型

            Breakable{failCount=1}
            Throwing Exception for handle
            result: Failure recovery obj   // handle(): 有异常则创建新结果

            Breakable{failCount=1}
            Throwing Exception for whenComplete
            It failed....                  // whenComplete(): 处理但是仍然向下传递相同的结果
        */

        System.out.println("---- 成功测试 ----");
        handleException(0);
    }
}
