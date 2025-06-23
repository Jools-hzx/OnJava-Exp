package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/12 14:50
 * @description: TODO
 */
public class Hamster extends Rodent {
    public Hamster() {
    }

    public Hamster(String name) {
        super(name);
    }
}
class Individual {
    String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }
}

class Person extends Individual {
    public Person(String name) {
        super(name);
    }

    public Person() {
        super();
    }
}

class Pet {
    String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }
}

class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }
}

class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
    }
}

class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
    }
}

class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }
}

class EgyptianMau extends Cat {
    public EgyptianMau() {
    }

    public EgyptianMau(String name) {
        super(name);
    }
}

class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
    }
}

class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
    }
}

class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
    }
}

class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
    }
}

class Mouse extends Rodent {
    public Mouse() {
    }

    public Mouse(String name) {
        super(name);
    }
}

