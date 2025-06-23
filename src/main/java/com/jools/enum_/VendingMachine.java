package com.jools.enum_;

import java.util.EnumMap;
import java.util.function.Supplier;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/29 19:24
 * @description: TODO
 */

enum Category {
    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SODA, Input.SOAP),
    QUIT_ACTION(Input.ABORT_TRANSACTION),
    SHUTDONW(Input.STOP);
    private Input[] values;

    // 构造器: 支持获取多个参数
    Category(Input... values) {
        this.values = values;
    }

    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    // 构建 Input 枚举实例归属的 Category
    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input inputs : c.values) {
                categories.put(inputs, c);
            }
        }
    }

    // 获取分类下的所有 Input
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;


    enum StateDuration {Transient}

    enum State {

        RESTING(StateDuration.Transient) {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUTDONW:
                        state = TERMINAL;
                    default:
                }

            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_ACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUTDONW:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.Transient) {
            @Override
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }

            @Override
            void output() {
                if (selection != null) {
                    System.out.println("Dispensing " + selection);
                    amount -= selection.amount();
                    selection = null;
                }
            }
        },
        GIVING_CHANGE(StateDuration.Transient) {
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }

            @Override
            void output() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration stateDuration) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call " + " next(Input inpt) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only can next() for " + "StateDuration transient states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    static void run(Supplier<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.get());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Supplier<Input> gen = new RandomInputSupplier();
        run(gen);
    }
}

class RandomInputSupplier implements Supplier<Input> {

    @Override
    public Input get() {
        return Input.randomSelection();
    }
}
