package com.jools.collections_;

/**
 * @author Jools He
 * @date 2025/6/16 20:10
 * @description: TODO
 */
public class AssociativeArray<K, V> {

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("earth", "brown");
        map.put("tree", "tall");
        map.put("sun", "warm");

        // 添加数目达到 6 个; 抛出异常
        try {
            map.put("extra", "object");
        } catch (Exception e) {
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));

        /*
         输出:
            Too many objects
            sky : blue
            grass : green
            ocean : dancing
            earth : brown
            tree : tall
            sun : warm
            dancing
        */
    }

    private Object[][] pairs;

    private int index;

    public AssociativeArray(int length) {
        this.pairs = new Object[length][2];
    }

    // 添加关联数组
    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    // 获取 K = key 的关联数组下标 1 的值
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
