package com.jools.generic_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/22 20:03
 * @description: TODO
 */

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}

class Teller {

    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }
}

class Bank {

    private List<BankTeller> tellers = new ArrayList<>();

    public void put(BankTeller t) {
        tellers.add(t);
    }
}

public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        // 演示 create()
        Collection<Teller> tellers = Suppliers.create(
                RandomList::new, Teller::new, 4
        );
        tellers.forEach(c -> System.out.print(c + " "));
        System.out.println("\n----------------------------");

        // 演示 fill - 版本二
        List<Customer> filled = Suppliers.fill(
                new ArrayList<>(), Customer::new, 12
        );
        filled.forEach(c -> System.out.print(c + " "));
        System.out.println("\n----------------------------");

        // 演示辅助类型机制 fill - 版本三
        Bank bank = Suppliers.fill(new Bank(), Bank::put, BankTeller::new, 3);
        List<Customer> customers = Suppliers.fill(new ArrayList<>(), List::add, Customer::new, 12);
        customers.forEach(c -> System.out.print(c + " "));

        /*
         输出:
            Teller{id=1} Teller{id=2} Teller{id=3} Teller{id=4}
            ----------------------------
            Customer{id=1} Customer{id=2} Customer{id=3} Customer{id=4} Customer{id=5}
            Customer{id=6} Customer{id=7} Customer{id=8} Customer{id=9} Customer{id=10}
            Customer{id=11} Customer{id=12}
            ----------------------------
            Customer{id=13} Customer{id=14} Customer{id=15} Customer{id=16} Customer{id=17}
            Customer{id=18} Customer{id=19} Customer{id=20} Customer{id=21} Customer{id=22}
            Customer{id=23} Customer{id=24}
        */
    }
}
