package com.jools.annotation_;

import org.junit.jupiter.api.Test;

/**
 * @author Jools He
 * @date 2025/6/17 17:25
 * @description: TODO
 */
public class StackLStringTst extends StackGeneric_<String> {

    @Test
    void tPush() {
        push("one");
        assert "one".equals(peek());
        push("two");
        assert "two".equals(peek());
    }

    @Test
    void tPop() {
        push("one");
        push("two");
        assert "two".equals(pop());
        assert "one".equals(pop());
    }

    @Test
    void tTop() {
        push("A");
        push("B");
        assert "A".equals(peek());
        assert "B".equals(peek());
    }
}




