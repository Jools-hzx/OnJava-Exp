package com.jools.reflection_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 15:00
 * @description: TODO
 */
public abstract class Creator implements Supplier<Pet> {

    private Random rand = new Random(47);

    // 创建不同类型的 Pet;
    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int num = rand.nextInt(types().size());
        try {
            return types().get(num).getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 获取一个无限流;
    public Stream<Pet> stream() {
        return Stream.generate(this);
    }

    // 获取一个有限流;
    public Pet[] array(int size) {
        return stream().limit(size).toArray(Pet[]::new);
    }

    // 获取一个有限流并且得到一个集合
    public List<Pet> list(int size) {
        return stream()
                .limit(size)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
