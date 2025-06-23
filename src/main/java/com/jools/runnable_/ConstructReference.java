package main.java.com.jools.runnable_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 19:46
 * @description: TODO
 */
public class ConstructReference {

    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        MakeOneArgs moa = Dog::new;
        MakeTwoArgs mta = Dog::new;

        mna.make();
        moa.make("Rover");
        mta.make("Spot", 3);
    }
}

interface MakeNoArgs {
    Dog make();
}

interface MakeOneArgs {
    Dog make(String name);
}

interface MakeTwoArgs {
    Dog make(String name, int age);
}

class Dog {
    String name;
    int age = -1;   // For "unknown"

    Dog() {
        name = "stray";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
