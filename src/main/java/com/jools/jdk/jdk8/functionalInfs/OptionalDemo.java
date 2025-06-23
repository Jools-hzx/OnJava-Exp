package com.jools.jdk.jdk8.functionalInfs;

import cn.hutool.core.comparator.ReverseComparator;
import cn.hutool.core.lang.Opt;
import lombok.Data;
import lombok.Setter;
import lombok.Value;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openjdk.jmh.annotations.State;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/13 16:46
 * @description: TODO
 */
public class OptionalDemo {

    @Test
    public void testOptionalApis() {
        Optional<String> name = Optional.of("Jools Wakoo");

        // 创建空 Optional 实例
        Optional<Object> empty = Optional.ofNullable(null);

        // isPresent 方法用来检测 Optional 实例是否有值
        if (name.isPresent()) {
            System.out.println(name.get()); // 调用 get() 返回 Optional 值
        }

        //在Optional实例上调用get()抛出NoSuchElementException。
        try {
            System.out.println(empty.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //ifPresent 方法接受 lambda 表达式参数
        name.ifPresent((v) -> {
            System.out.println("The length of the value is:" + v.length()); //The length of the value is:11
        });

        // orElse 返回 Optional 实例，否则返回传入的错误信息
        System.out.println(empty.orElse("There is no value present!")); //There is no value present!
        System.out.println(name.orElse("There is some value!!"));

        // orElseGet 与 orElse 类似，区别于传入的默认值
        System.out.println(name.orElseGet(() -> "Default Value"));
        System.out.println(empty.orElseGet(() -> "Default Value"));     // Default Value

        try {
            empty.orElseThrow(RuntimeException::new);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //null
        }

        // map 方法通过传入 lambda 表达式修改 Optional 实例为默认值
        Optional<String> upperName = name.map((v) -> v.toUpperCase());
        System.out.println(upperName.orElse("No value found!!"));   // JOOLS WAKOO

        Optional<String> flatUpperName = name.flatMap((v) -> Optional.of(v.toUpperCase()));
        System.out.println(flatUpperName.orElse("No value found!!!"));  // JOOLS WAKOO

        //filter 方法检查 Optional 值是否满足给定条件
        Optional<String> ans = name.filter((v) -> v.length() > 6);
        System.out.println(ans.orElse("The name is less than length of 6"));    //Jools Wakoo
    }

    @Test
    public void testMapAndFlatMap() {

        List<String[]> listOfArray = Arrays.asList(
                new String[]{"apple", "banna", "cherry"},
                new String[]{"orange", "grape", "pear"},
                new String[]{"kiwi", "melon", "pineapple"}
        );

        // map()
        List<String[]> mapList = listOfArray.stream().map(
                arr -> Arrays.stream(arr).map(String::toUpperCase).toArray(String[]::new)
        ).collect(Collectors.toList());

        mapList.forEach(arr -> System.out.println(Arrays.toString(arr)));
        /*
         输出结果:
         [APPLE, BANNA, CHERRY]
         [ORANGE, GRAPE, PEAR]
         [KIWI, MELON, PINEAPPLE]
         */

        // flatMap() 方法
        List<String> flatMapList = listOfArray.stream().flatMap(
                arr -> Arrays.stream(arr).map(String::toUpperCase)
        ).collect(Collectors.toList());

        System.out.println("Using flatMap:" + flatMapList);
        // 输出结果: [APPLE, BANNA, CHERRY, ORANGE, GRAPE, PEAR, KIWI, MELON, PINEAPPLE]
    }

    public static void main(String[] args) {

        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        } else {
            System.out.println("Fields is still none!!!");
        }

        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);

        Outer otr = new Outer();
        resolve(() -> otr.getNested().getInner().getFoo()).ifPresent(System.out::println);
    }

    private static Pets getPets() {
        Cat cat = new Cat();
        cat.setName("cat");
        Pets pets = new Pets();
        pets.setCat(cat);
        return pets;
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T t = resolver.get();
            return Optional.ofNullable(t);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

class Outer {
    Nested nested;

    Nested getNested() {
        return nested;
    }
}

class Nested {
    Inner inner;

    Inner getInner() {
        return inner;
    }
}

class Inner {
    String foo;

    String getFoo() {
        return foo;
    }
}

@Data
class Pets {
    private Cat cat;
}

@Data
class Cat {
    private String name;
}


