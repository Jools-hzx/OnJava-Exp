package com.jools.concurrent;

/**
 * @author Jools He
 * @date 2025/6/19 15:54
 * @description: TODO
 */
public class LimitStateMachine {

    public enum State {
        START, ONT, TWO, THREE, END;

        State step() {
            if (equals(END)) {
                return END;
            }
            return values()[ordinal() + 1];
        }
    }

    private State state = State.START;

    private final int id;

    public LimitStateMachine(int id) {
        this.id = id;
    }

    public static LimitStateMachine work(LimitStateMachine m) {
        if (!m.state.equals(State.END)) {
            new Nap(0.1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "LimitStateMachine [id=" + id + " : "
                + (state.equals(State.END) ? "complete!" : state)
                + "]";
    }
}
