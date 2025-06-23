package com.jools.highconcurrency.jucMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/28 1:46
 * @description: TODO
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // 多线程存储键值对
        for (int i = 0; i < 100; i++) {
            final int index = i;
            new Thread(() -> {
                map.put("key" + index, index);
                System.out.println(Thread.currentThread().getName() + " 插入 key" + index);
            }).start();
        }

        // 主线程读取
        try {
            Thread.sleep(1000); // 等待子线程完成
            System.out.println("最终结果：" + map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
