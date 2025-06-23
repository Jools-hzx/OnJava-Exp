package main.java.com.jools.functional_;

import java.util.function.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/22 23:06
 * @description: TODO
 */

class Foo {
}

class Bar {
    Foo f;

    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;

    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    DBaz(double d) {
        this.d = d;
    }
}

public class FunctionVariants {

    static Function<Foo, Bar> f1 = f -> new Bar(f); // 返回 Bar 实例
    static IntFunction<IBaz> f2 = i -> new IBaz(i); // 返回 IBaz 实例
    static LongFunction<LBaz> f3 = i -> new LBaz(i);    // 返回 LBaz 实例
    static DoubleFunction<DBaz> f4 = d -> new DBaz(d);  // 返回 DBaz 实例
    static ToIntFunction<IBaz> f5 = ib -> ib.i; // 获取 int
    static ToLongFunction<LBaz> f6 = lb -> lb.l; // 获取 long
    static ToDoubleFunction<DBaz> f7 = db -> db.d;  // 获取 double
    static IntToDoubleFunction f8 = i -> i; // int 转 double
    static IntToLongFunction f9 = i -> i;   // int 转 long
    static LongToIntFunction f10 = l -> (int) l;     // long 转 int
    static LongToDoubleFunction f11 = l -> l;   // long 转 double
    static DoubleToIntFunction f12 = d -> (int) d;  // double 转 int
    static DoubleToLongFunction f13 = d -> (long) d; // double 转 long

    public static void main(String[] args) {
        Bar b = f1.apply(new Foo());
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11);
        DBaz db = f4.apply(11);
        int i = f5.applyAsInt(ib);
        long l = f6.applyAsLong(lb);
        double d = f7.applyAsDouble(db);

        double dd = f8.applyAsDouble(22);
        long ll = f9.applyAsLong(22);
        int ii = f10.applyAsInt(22L);
        int iii = f12.applyAsInt(22.2);
        long lll = f13.applyAsLong(22.2);
    }
}
