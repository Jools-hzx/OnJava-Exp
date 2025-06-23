package com.jools.reflection_;


import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Jools He
 * @description: 基于基类 Part 的注册工厂
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(10)
                .forEach(System.out::println);

        /*
         输出结果:
            PowerSteering
            OilFilter
            FanBelt
            FuelFilter
            AirFilter
            FanBelt
            AirFilter
            OilFilter
            FanBelt
            PowerSteering
        */
    }
}

// 基类 Part
class Part implements Supplier<Part> {

    //基于 Part 的注册工厂
    static List<Supplier<? extends Part>> prototypes = List.of(
            new FuelFilter(),
            new AirFilter(),
            new CabinAirFilter(),
            new OilFilter(),
            new FanBelt(),
            new PowerSteering(),
            new GeneratorBelt(),
            new Belts()
    );

    private static Random rand = new Random(47);

    @Override
    public Part get() {
        // 随机返回 Part 其中一个子类实例
        int n = rand.nextInt(prototypes.size());
        return prototypes.get(n).get();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

// 子类 PowerSteering 继承 Part
class PowerSteering extends Part {
    @Override
    public Part get() {
        return new PowerSteering();
    }
}

// 次基类 Filter 继承 Part
class Filter extends Part {
}

// 子类 1
class FuelFilter extends Filter {
    @Override
    public Part get() {
        return new FuelFilter();
    }
}

// 子类 2
class AirFilter extends Filter {
    @Override
    public Part get() {
        return new AirFilter();
    }
}

// 子类 3
class CabinAirFilter extends Filter {
    @Override
    public Part get() {
        return new CabinAirFilter();
    }
}

// 子类 4
class OilFilter extends Filter {
    @Override
    public Part get() {
        return new OilFilter();
    }
}

// 次基类 - Belts
class Belts extends Part {
}

// 子类 FanBelt 继承 Belts
class FanBelt extends Belts {
    @Override
    public Part get() {
        return new FanBelt();
    }
}

// 子类 GeneratorBelt 继承 Belts
class GeneratorBelt extends Belts {
    @Override
    public Part get() {
        return new GeneratorBelt();
    }
}


