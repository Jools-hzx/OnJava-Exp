package com.jools.jdk.jdk8.functionalInfs;

import com.sun.jdi.VoidValue;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/7 15:00
 * @description: TODO
 */
public class FunctionalInterfacesDemo {

    public static void main(String[] args) {

        IFunctionalInterface impl = new IFunctionalInterface() {
            @Override
            public String addPrefix(String msg) {
                return IFunctionalInterface.DEFAULT_PERFIX + msg;
            }
        };

        String ans = impl.addPrefix("Hello!! World!!!");
        System.out.println(ans);    // 输出:i-functional-interface:Hello!! World!!!
    }

    @Test
    public void testConsumer() {
        Consumer<Person> greeter = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Hello!" + person.name);
            }
        };
        greeter.accept(new Person("A"));
        greeter.accept(new Person("B"));

        /*
            Hello!A
            Hello!B
        */
    }

    @Test
    public void testConsumerAndThen() {

        // 创建一个用户列表
        List<User> users = new ArrayList<>();
        users.add(new User("AA", 11));
        users.add(new User("BB", 22));
        users.add(new User("CC", 33));

        //首个 Consumer, 输出用户名
        Consumer<User> printUserName = (user) -> {
            System.out.println("用户名" + user.name);
        };

        //第二个 Consumer, 输出年龄
        Consumer<User> showUserAge = (user -> {
            System.out.println("用户年龄:" + user.age);
        });

        //借助 andThen 方法组合
        Consumer<User> combineUsers = printUserName.andThen(showUserAge);

        //借助 forEach 遍历
        users.forEach(combineUsers);

        /*
            用户名AA
            用户年龄:11
            用户名BB
            用户年龄:22
            用户名CC
            用户年龄:33
        */
    }

    @Test
    public void testSupplier() {
        Supplier<User> userSupplier = new Supplier<User>() {

            private Random random = new Random(10);

            @Override
            public User get() {
                return new User("user-" + random.nextInt(100000), random.nextInt(50));
            }
        };

        for (int i = 0; i < 5; i++) {
            User user = userSupplier.get();
            System.out.println(user);
        }

        /*
         输出:
            User{name='user-87113', age=30}
            User{name='user-27293', age=40}
            User{name='user-35246', age=6}
            User{name='user-37797', age=38}
            User{name='user-78981', age=14}
        */
    }

    @Test
    public void testPredicate() {

        // Predicate 01 比较用户名的长度是否大于 5
        Predicate<User> userNamePredicate = (user -> user.name.length() > 5);

        User user = new User("12345678", 11);
        Assert.assertTrue(userNamePredicate.test(user));   //true
        Assert.assertFalse(userNamePredicate.negate().test(user));  //false

        Predicate<User> notUserNamePerdicate = Predicate.not(userNamePredicate);
        Assert.assertFalse(notUserNamePerdicate.test(user));    //false

        // Predicate 02 比较用户年龄是否大于等于 20
        Predicate<User> userAgePredicate = (u -> u.age >= 20);
        Assert.assertFalse(userAgePredicate.test(user));    // false


        Predicate<User> ageNameAndPredicator = userNamePredicate.and(userAgePredicate);
        Assert.assertFalse(ageNameAndPredicator.test(user)); // false 年龄不满足

        Predicate<User> nameAgeOrPredicator = userNamePredicate.or(ageNameAndPredicator);
        Assert.assertTrue(nameAgeOrPredicator.test(user)); // name 名称长度满足
    }

    @Test
    public void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Integer ans = toInteger.apply("100");
        Assert.assertEquals(ans, (Integer) 100);

        // 组合: 后置处理  str -> double ->  str
        Function<String, Double> toDouble = Double::parseDouble;
        Function<Double, String> backToStirng = String::valueOf;
        Function<String, String> andThen = toDouble.andThen(backToStirng);

        String ansStr = andThen.apply("2000");
        Assert.assertEquals("2000.0", ansStr);

        //组合: 前置处理  str -> int -> double
        Function<String, Integer> toInt = Integer::valueOf;
        Function<Integer, Double> intToDouble = Double::valueOf;
        Function<String, Double> strToDouble = intToDouble.compose(toInt);
        Double ansDouble = strToDouble.apply("11111");

        Assert.assertEquals(Double.valueOf("11111.0"), ansDouble);
    }

    @Test
    public void testMapReduce() {
        List<Integer> before = Arrays.asList(100, 200, 300, 400, 500);
        Double addTax = before.stream().map(cost -> cost + 0.12 * cost).reduce((sum, cost) -> sum + cost).get();
        Integer beforeCost = before.stream().reduce((sum, cost) -> sum + cost).get();

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining("///"));
        /*
         输出:  USA///JAPAN///FRANCE///GERMANY///ITALY///U.K.///CANADA
        */

        List<String> strCollections = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strCollections.add("abcde-" + i);
        }

        boolean anyMatch = strCollections.stream().anyMatch((s) -> s.startsWith("a"));          // true
        boolean allStartsWithA = strCollections.stream().allMatch((s) -> s.startsWith("a"));    // true
        boolean noneStartWithZ = strCollections.stream().noneMatch((s) -> s.startsWith("z"));   // true

        System.out.println(anyMatch);
        System.out.println(allStartsWithA);
        System.out.println(noneStartWithZ);

        Optional<String> op = Optional.of("Jools Wakoo");
        Optional<String> strOp = op.map((v) -> v.toUpperCase());
        Optional<String> flatMapOp = op.flatMap((v) -> Optional.of(v.toUpperCase()));
    }
}

class User {

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}


@FunctionalInterface
interface IFunctionalInterface {

    static final String DEFAULT_PERFIX = "i-functional-interface:";

    String addPrefix(String msg);
}

//错误: Multiple non-overriding abstract methods found in interface com.jools.jdk.jdk8.functionalInfs.f1
@FunctionalInterface
interface f1 {

    void m1();
}

