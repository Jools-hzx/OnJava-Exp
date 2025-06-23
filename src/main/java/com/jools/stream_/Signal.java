package main.java.com.jools.stream_;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Signal {

    // 信息
    private final String msg;

    // 信号
    public Signal(String msg) {
        this.msg = msg;
    }

    // 获取消息
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Signal [" +
                " (" + msg + ") " +
                ']';
    }

    static Random rand = new Random(47);

    // 随机生成 Signal 对象
    public static Signal morse() {
        switch (rand.nextInt(4)) {
            case 1:
                return new Signal("dot");
            case 2:
                return new Signal("dash");
            default:
                return null;
        }
    }


    // 生成 Optional<Signal> 的 Stream
    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse).map(
                Optional::ofNullable);
    }
}
