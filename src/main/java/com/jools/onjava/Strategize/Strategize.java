package main.java.com.jools.onjava.Strategize;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/20 22:41
 * @description: TODO
 */
public class Strategize {


    Strategy strategy;
    String msg;

    // Strategy 类的实现字段默认是 Soft 实例
    public Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    // 执行 Strategy 实现对象的方法
    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    // 更新 Strategy 实现对象
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {

        // Strategy 实现对象数组，存储三个不同的 Strategy 实现类并重写 approach 方法
        Strategy[] startegies = {
                new Strategy() {        // 1. 创建匿名内部类01: 使用更加简洁、自然的方式创建一个匿名内部类
                    @Override
                    public String approach(String msg) {
                        return msg.toLowerCase() + "!!!!!";
                    }
                },
                msg -> msg.toUpperCase() + "?????", // 2. lambda 表达式，突出的特点是箭头 -> 将参数和函数体分割开来
                Unrelated::twice    // Java 8 中的方法引用实现
        };

        Strategize s = new Strategize(" HELLO");
        s.communicate();
        for (Strategy newStrategy : startegies) {
            s.changeStrategy(newStrategy);
            s.communicate();
        }

        /*
         输出结果:
            hello
            hello!!!!!
            HELLO?????
            HELLO  HELLO
        */
    }
}

interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toLowerCase();
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}
