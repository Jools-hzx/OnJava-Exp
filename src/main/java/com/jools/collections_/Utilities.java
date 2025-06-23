package com.jools.collections_;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Jools He
 * @date 2025/6/17 14:14
 * @description: TODO
 */
public class Utilities {

    static List<String> list = Arrays.asList(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
    );


    @Test
    public void testSearch() {
        ArrayList<String> list = new ArrayList<>(Utilities.list);
        list.addAll(list);
        System.out.println(list);

        Collections.shuffle(list, new Random(47));
        System.out.println("Shuffled: " + list);
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println("Trimmed: " + list);
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        String key = list.get(4);
        int index = Collections.binarySearch(list, key);
        System.out.println("The location of " + key + " is " + index + ", using Collections.binarySearch()");
        //

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + list);
        key = list.get(5);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        System.out.println("The location of " + key + " is " + index + ", using Collections.binarySearch()");

        /*
         输出结果:
            [one, two, three, four, five, six, seven, eight, nine, ten, one, two, three, four, five, six, seven, eight, nine, ten]
            Shuffled: [eight, eight, two, five, ten, seven, two, ten, four, nine, six, three, seven, one, five, three, six, four, one, nine]
            Trimmed: [eight, eight, two, five, ten, seven, two, ten, four, nine]
            Sorted: [eight, eight, five, four, nine, seven, ten, ten, two, two]
            The location of nine is 4, using Collections.binarySearch()
            Case-insensitive sort: [eight, eight, five, four, nine, seven, ten, ten, two, two]
            The location of seven is 5, using Collections.binarySearch()
        */
    }

    public static void main(String[] args) {

        System.out.println(list);
        // 输出: [one, two, three, four, five, six, seven, eight, nine, ten]

        // 拼接 - 没有公共的元素则返回 true
        List<String> eleven = List.of("Eleven");
        System.out.println("disjoint:" +  Collections.disjoint(list, eleven));

        // 最大最小值
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));

        // 不考虑大小写最大最小
        System.out.println("max [case insensitive order]: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        System.out.println("min [case insensitive order]: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        // 查询子集合所在的起始下标
        List<String> sub = Arrays.asList("four", "five", "six");
        System.out.println("indexOfSubList(): " + Collections.indexOfSubList(list, sub));   // 3

        // 替换
        Collections.replaceAll(list, "one", "ONE");
        System.out.println(list);

        // 反转
        Collections.reverse(list);
        System.out.println(list);

        // 向前移动
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        // [ten, nine, eight, seven, six, five, four, three, two, ONE]

        // 拷贝
        List<String> source = Arrays.asList("in the matrix");
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        // 拷贝结果: [in the matrix, two, ONE, ten, nine, eight, seven, six, five, four]

        // 交换
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);
        // 输出结果: [four, two, ONE, ten, nine, eight, seven, six, five, in the matrix]

        // 打乱
        Collections.shuffle(list);
        System.out.println("shuffle: " + list);

        // 填充
        Collections.fill(list, "pop");
        System.out.println("shuffle: " + list);

        // 统计某个元素的出现次数
        int cnt = Collections.frequency(list, "pop");
        System.out.println("frequency: " + cnt);

        List<String> snap = Collections.nCopies(3, "snap");
        System.out.println("snaps: " + snap);

        // 获得一个老式的 Enueration
        Enumeration<String> e = Collections.enumeration(snap);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }

        // 转换成一个 List
        ArrayList<String> arrayList = Collections.list(v.elements());
        System.out.println("ArrayList: " + arrayList);
    }
}
