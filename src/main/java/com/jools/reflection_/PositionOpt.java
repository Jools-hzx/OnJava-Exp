package com.jools.reflection_;

import java.util.Optional;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 20:19
 * @description: TODO
 */
public class PositionOpt {

    public static void main(String[] args) {
        // 创建一个职位但是暂时空缺，PersonOpt 实例字段为空
        System.out.println(new Position("CEO"));
        // 创建一个职位并且同时指定了个人信息
        System.out.println(new Position("Programmer",
                new PersonOpt("Jools", "He", "Shenzhen Nanshan District")));
        try {
            new Position(null);
        } catch (Exception e) {
            System.out.println("Caught Exception !!" + e);
        }

        /*
         输出:
            Position title:CEO, Employee:<Empty>
            Position title:Programmer, Employee:Jools -> He -> Shenzhen Nanshan District
            Caught Exception !!com.jools.reflection_.EmptyTitleException
        */
    }
}

class EmptyTitleException extends RuntimeException {
}

class Position {
    private String title;
    private PersonOpt person;

    public Position(String title, PersonOpt person) {
        setTitle(title);
        setPerson(person);
    }

    // 复用全参构造器
    public Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return title;
    }

    public PersonOpt getPerson() {
        return person;
    }

    public void setTitle(String title) {
        // 如果 title 为空，则会抛出异常
        this.title = Optional.ofNullable(title)
                .orElseThrow(EmptyTitleException::new);
    }

    public void setPerson(PersonOpt person) {
        // 如果 PersonOpt 为空，则使用一个新的空 PersonOpt
        this.person = Optional.ofNullable(person)
                .orElse(new PersonOpt());
    }

    @Override
    public String toString() {
        return "Position title:" + title +
                ", Employee:" + person;
    }
}
