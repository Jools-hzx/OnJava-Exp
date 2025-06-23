package com.jools.collections_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 17:00
 * @description: TODO
 */
public class Pair<K, V> {

    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key() {
        return key;
    }

    public V value() {
        return value;
    }

    public static <K, V> Pair<K, V> make(K key, V value) {
        return new Pair<>(key, value);
    }
}
