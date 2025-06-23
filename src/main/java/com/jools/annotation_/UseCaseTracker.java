package com.jools.annotation_;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jools He
 * @date 2025/6/17 16:18
 * @description: TODO
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                // 如果注解中该 id 存在于 useCases
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        // 剩余 id 未被 cls 各个方法指定为 @UseCase id
        useCases.forEach(i -> {
            System.out.println("Warning: Missing use case - " + i);
        });
    }

    public static void main(String[] args) {
        List<Integer> selectedIds = IntStream.range(47, 51).boxed().collect(Collectors.toList());
        trackUseCases(selectedIds, PasswordUtils.class);

        /*
         输出结果:
            Found Use Case: 48 no description   // 没有指定 description 则返回默认 no description
            Found Use Case: 49 New passwords can't equal previously used ones
            Found Use Case: 47 Passwords must contain at least one numeric
            Warning: Missing use case - 50
        */
    }
}
