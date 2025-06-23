package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 15:06
 * @description: TODO
 */
public class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}

class OnOffSwitch {

    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {
    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }

        /*
         输出:
         on
         off
        */
    }
}

class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        sw.on();
        try {
            OnOffSwitch.f();
        } catch (OnOffException1 | OnOffException2 e) {
            throw new RuntimeException(e);
        } finally {
            sw.off();
        }
    }
}


class OnOffException1 extends Exception {

}

class OnOffException2 extends Exception {

}
