package com.jools.unitTest;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 22:33
 * @description: TODO
 */
public class CountedListTest {

    private CountedList list;

    @Test
    public void testAssertion01() {
        assert false;
    }

    @Test
    public void testAssertion02() {
        assert false :
                "Here's a message saying what happend!";

    }

    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>>> In @BeforeAll; Starting CountList Test");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>>> In @AfterAll; Finished CountList Test");
    }

    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println(">>>> Set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }
    }

    @AfterEach
    public void cleanup() {
        System.out.println(">>>> In cleanup() " + list.getId());
    }

    @Test
    public void insert() {
        System.out.println(">>> Running testInsert()");
        assertEquals(3, list.size());
        list.add(1, "Insert");
        assertEquals(4, list.size());
        assertEquals(list.get(1), "Insert");

        /*
         输出 [单次执行]:
            >>>> In @BeforeAll; Starting CountList Test
            CountList-#0
            >>>> Set up for 0
            >>> Running testInsert()
            >>>> In cleanup() 0
            >>>> In @AfterAll; Finished CountList Test
        */
    }

    @Test
    public void replace() {
        System.out.println(">>> Running testReplace()");
        assertEquals(list.size(), 3);
        list.set(1, "Replace");
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "Replace");
        /*
         输出 [单次执行]:
            >>>> In @BeforeAll; Starting CountList Test
            CountList-#0
            >>>> Set up for 0
            >>> Running testReplace()
            >>>> In cleanup() 0
            >>>> In @AfterAll; Finished CountList Test
        */
    }

    // 没有被 @Test 注解的方法不会被 @JUnit 自动执行
    private void compare(List<String> list, String[] strs) {
        assertArrayEquals(list.toArray(new String[0]), strs);
    }

    @Test
    public void order() {
        System.out.println(">>> Running and testing order()");
        compare(list, new String[]{"0", "1", "2"});
        /*
        输出 [单次执行] :
            >>>> In @BeforeAll; Starting CountList Test
            CountList-#0
            >>>> Set up for 0
            >>> Running and testing order()
            >>>> In cleanup() 0
            >>>> In @AfterAll; Finished CountList Test
        */
    }

    @Test
    public void remove() {
        System.out.println(">>> Running testRemove()");
        assertEquals(list.size(), 3);
        list.remove(1);
        assertEquals(2, list.size());
        compare(list, new String[]{"0", "2"});

        /*
        输出 [单次执行]:
            >>>> In @BeforeAll; Starting CountList Test
            CountList-#0
            >>>> Set up for 0
            >>> Running testRemove()
            >>>> In cleanup() 0
            >>>> In @AfterAll; Finished CountList Test
        */
    }

    @Test
    public void addAll() {
        System.out.println(">>> Running addAll()");
        list.addAll(Arrays.asList("An", "African", "Swallow"));
        assertEquals(list.size(), 6);
        compare(list, new String[]{
                "0", "1", "2", "An", "African", "Swallow"
        });
        /*
        输出 [单次执行]:
        >>>> In @BeforeAll; Starting CountList Test
        CountList-#0
        >>>> Set up for 0
        >>> Running addAll()
        >>>> In cleanup() 0
        >>>> In @AfterAll; Finished CountList Test
        */
    }
}
