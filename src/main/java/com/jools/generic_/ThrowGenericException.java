package com.jools.generic_;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 21:21
 * @description: TODO
 */
public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }

        /*
         输出结果:
            [Hep!!!, Hep!!!, Ho!!!]
            com.jools.generic_.Failure2
        */
    }
}

// 接口，基于泛型类型控制异常和具体类型
interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

// 继承基类 Exception
class Failure1 extends Exception {}

class ProcessRunner<T, E extends Exception>
        extends ArrayList<Processor<T, E>> {

    List<T> processAll() throws E {
        List<T> resultController = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultController);
        }
        return resultController;
    }
}

// 指定泛型类型为 String, 控制异常抛出类型为 Failure1
class Processor1 implements Processor<String, Failure1> {

    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if(count-- > 1) {
            resultCollector.add("Hep!!!");
        } else {
            resultCollector.add("Ho!!!");
        }
        if (count < 0) {
            throw new Failure1();
        }
    }
}

// 继承基类 Exception
class Failure2 extends Exception {}

// 指定泛型类型为 String, 控制异常抛出类型为 Failure2
class Processor2 implements Processor<Integer, Failure2> {

    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0){
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}

