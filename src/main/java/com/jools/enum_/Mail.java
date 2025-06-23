package com.jools.enum_;

import java.util.Iterator;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 19:08
 * @description: TODO
 */
public class Mail {

    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0L;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this + ", General Delivery:" + generalDelivery
                + ", Scannability:" + scannability +
                ", Readability:" + readability
                + ", Address:" + address +
                ", Return Address:" + returnAddress;
    }

    // 生成测试邮件
    public static Mail randomMail() {
        Mail m = new Mail();
        // 随机选取枚举实例填充
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    // 返回迭代器
    public static Iterable<Mail> gen(final int count) {
        // 匿名内部类 Iterable
        return () -> {
            final int[] n = {count};
            return new Iterator<Mail>() {
                @Override
                public boolean hasNext() {
                    return n[0]-- > 0;
                }

                @Override
                public Mail next() {
                    return randomMail();
                }

                @Override
                public void remove() {
                    throw new RuntimeException("Unsupported Operation!!");
                }
            };
        };
    }
}
