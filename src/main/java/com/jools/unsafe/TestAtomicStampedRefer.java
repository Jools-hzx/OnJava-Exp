package com.jools.unsafe;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/30 1:06
 * @description: TODO
 */
public class TestAtomicStampedRefer {
    private AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 0);

    public void updateValue(int expected, int newValue) {
        int[] stampHolder = new int[1];

        /*
            public V get(int[] stampHolder) {
                Pair<V> pair = this.pair;
                stampHolder[0] = pair.stamp;
                return pair.reference;
            }
        */
        Integer currentValue = atomicStampedReference.get(stampHolder);
        System.out.println("Current value:" + currentValue);
        int currentStamp = stampHolder[0];

        boolean updated = atomicStampedReference.compareAndSet(expected, newValue, currentStamp, currentStamp + 1);
        if (updated) {
            System.out.println("Value updated to " + newValue);
        } else {
            System.out.println("Update failed");
        }
    }

    @Test
    public void testUpdate() {
        TestAtomicStampedRefer stampedRefer = new TestAtomicStampedRefer();
        stampedRefer.updateValue(0, 1);

        /*
         输出结果:
            Current value:0
            Value updated to 1
        */
    }
}

