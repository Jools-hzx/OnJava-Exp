package com.jools.generic_;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 17:56
 * @description: TODO
 */

class Employee {
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee";
    }
}

class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            // 借助反射生成 T 类型的实例
            return kind.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.get());

        ClassAsFactory<Integer> fint = new ClassAsFactory<>(Integer.class);

        try {
            System.out.println(fint.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         输出结果:
            Employee
            java.lang.NoSuchMethodException: java.lang.Integer.<init>()
        */
    }
}
