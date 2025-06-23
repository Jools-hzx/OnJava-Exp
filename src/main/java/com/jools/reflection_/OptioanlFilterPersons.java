package com.jools.reflection_;

import java.util.Optional;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 19:56
 * @description: TODO
 */
public class OptioanlFilterPersons {

    public static void main(String[] args) {
        // 构造多个 Person; 分别传入多个不同的空值
        System.out.println(new PersonOpt());
        System.out.println(new PersonOpt("Jools"));
        System.out.println(new PersonOpt("Jools", "He"));
        System.out.println(new PersonOpt("Jools", "Wakoo", "Shenzhen Nanshan District"));

        /*
         输出:
            <Empty>
            Jools ->  ->
            Jools -> He ->
            Jools -> Wakoo -> Shenzhen Nanshan District
        */
    }
}

class PersonOpt {

    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;

    public final boolean empty;

    PersonOpt(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        // 是否为空基于输入
        this.empty = this.first.isEmpty() &&
                this.last.isEmpty() &&
                this.address.isEmpty();
    }

    // 复用构造器01
    PersonOpt(String first, String last) {
        this(first, last, null);
    }

    // 复用构造器 02
    PersonOpt(String first) {
        this(first, null, null);
    }

    // 复用构造器 03
    PersonOpt() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        // 如果为空
        if (empty) {
            return "<Empty>";
        }
        return (first.orElse("") + " -> " +
                last.orElse("") + " -> " +
                address.orElse(" "));
    }
}