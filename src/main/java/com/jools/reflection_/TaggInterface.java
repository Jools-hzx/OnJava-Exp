package com.jools.reflection_;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 22:43
 * @description: TODO
 */
public class TaggInterface {

    public static void main(String[] args) {
        Robot.test(new SnowRobot("Jools He の SnowRobot"));

        /*
         执行结果:
            Robot Name:Jools He の SnowRobot
            Robot model:SnowBot Series 11
            Robot start operating.....
            -------
            Jools He の SnowRobot is used to shovel snow
            Jools He の SnowRobotshoveling snow!!!!
            -------
            Jools He の SnowRobot can chip ice
            Jools He の SnowRobot chipping ice
            -------
            Jools He の SnowRobot can clear the roof
            Jools He の SnowRobot clearing roof
        */
    }

    @Test
    public void testNullProxy() {
        // 首先调用正常 Robot 实现类的 test; 之后调用代理对象拦截的 test
        Stream.of(
                new SnowRobot("Jools の Snow Robot"),
                NullRobotCreator.newNullRobot(SnowRobot.class)
        ).forEach(Robot::test);
        /*
         执行结果:
            Robot Name:Jools の Snow Robot
            Robot model:SnowBot Series 11
            Robot start operating.....
            -------
            Jools の Snow Robot is used to shovel snow
            Jools の Snow Robotshoveling snow!!!!
            -------
            Jools の Snow Robot can chip ice
            Jools の Snow Robot chipping ice
            -------
            Jools の Snow Robot can clear the roof
            Jools の Snow Robot clearing roof
            [Null Robot]
            Robot Name:NRobot  - [generated bt NullRobotProxy]
            Robot model:NRobot  - [generated bt NullRobotProxy]
            Robot start operating.....
         */
    }
}

class NullRobotCreator {
    public static Robot newNullRobot(Class<? extends Robot> t) {
        return (Robot) Proxy.newProxyInstance(
                NullRobotCreator.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(t)
        );
    }
}

class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> t) {
        this.nullName = proxied.getClass().getSimpleName() + "  - [generated bt NullRobotProxy]";
    }

    // 内部类，实现了 Null 标记接口 + Robot
    private class NRobot implements Null, Robot {

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}

class SnowRobot implements Robot {
    private String name;

    public SnowRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation(
                        () -> name + " is used to shovel snow",
                        () -> System.out.println(name + "shoveling snow!!!!")),
                new Operation(
                        () -> name + " can chip ice",
                        () -> System.out.println(name + " chipping ice")),
                new Operation(
                        () -> name + " can clear the roof",
                        () -> System.out.println(name + " clearing roof")));
    }
}

interface Null {
}

interface Robot {

    String name();

    String model();

    // 借助 operations 来访问机器人支持的服务
    List<Operation> operations();

    static void test(Robot r) {
        if (r instanceof Null) {
            System.out.println("[Null Robot]");
        }
        System.out.println("Robot Name:" + r.name());
        System.out.println("Robot model:" + r.model());
        System.out.println("Robot start operating.....");
        for (Operation operation : r.operations()) {
            System.out.println("-------");
            System.out.println(operation.description.get());
            operation.command.run();
        }
    }
}

/**
 * 包含了一个描述和命令 [一种命令模式]
 * 定义为对函数式接口的引用；可以将 lambda 表达式或者方法引用传递给 Operation 构造器
 */
class Operation {

    public final Supplier<String> description;
    public final Runnable command;

    public Operation(Supplier<String> descr, Runnable command) {
        this.description = descr;
        this.command = command;
    }
}
