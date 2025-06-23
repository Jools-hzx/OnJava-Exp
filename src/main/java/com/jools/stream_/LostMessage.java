package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 15:35
 * @description: TODO
 */
public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {

        LostMessage lostMessage = new LostMessage();
        try {
            try {
                lostMessage.f();        // 抛出的是: VeryImportantException
            } finally {
                lostMessage.dispose();  // 抛出的是: HoHumException
            }
        } catch (VeryImportantException | HoHumException e) {
            System.out.println(e);
        }

        /* 仅输出了: A trivial exception */
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}
