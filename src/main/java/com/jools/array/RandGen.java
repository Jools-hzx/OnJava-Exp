package com.jools.array;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public interface RandGen {

    int MOD = 10_000;

    class Boolean implements Supplier<java.lang.Boolean> {
        SplittableRandom rand = new SplittableRandom(47);

        @Override
        public java.lang.Boolean get() {
            return rand.nextBoolean();
        }

        public java.lang.Boolean get(int n) {
            return get();
        }

        public java.lang.Boolean[] array(int sz) {
            java.lang.Boolean[] res = new java.lang.Boolean[sz];
            Arrays.setAll(res, bArr -> get());
            return res;
        }
    }

    class Pint implements IntSupplier {
        SplittableRandom rand = new SplittableRandom(47);

        @Override
        public int getAsInt() {
            return rand.nextInt(MOD);
        }

        public int get(int n) {
            return getAsInt();
        }

        public int[] array(int sz) {
            return rand.ints(sz, 0, MOD).toArray();
        }
    }

    class Integer implements Supplier<java.lang.Integer> {
        SplittableRandom rand = new SplittableRandom(47);

        @Override
        public java.lang.Integer get() {
            return rand.nextInt(MOD);
        }

        public java.lang.Integer get(int n) {
            return get();
        }

        public java.lang.Integer[] array(int sz) {
            int[] arr = new Pint().array(sz);
            java.lang.Integer[] res = new java.lang.Integer[sz];
            for (int i = 0; i < sz; i++) {
                res[i] = arr[i];
            }
            return res;
        }
    }
}
