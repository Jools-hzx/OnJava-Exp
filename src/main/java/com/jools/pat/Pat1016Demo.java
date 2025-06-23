package main.java.com.jools.pat;

import java.util.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/25 19:57
 * @description: TODO
 */
public class Pat1016Demo {

    /*
     1. 输入的第一部分，包含 24 个整数，依次代表 0 ~ 1 1 ~ 2 等小时区间的费用
     2. 输入的第二部分: 顾客姓名 时间 on-line 和 off-line
     3. 每一个 on-line 需要与 off-line 配对；否则进行忽略
     3. 输出格式: 每一通电话的 起始时间 结束时间 持续接通时间 费用
    */

    private static int[] monthToDay = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    private static int dayToMin = 24 * 60;
    private static int hourToMin = 60;
    static int[] prices = new int[24];

    /*
     1. 长度为 24 的数组统计各个时间区间内的费用标准
     2. 基于 dd:hh:mm:ss 计算两个时间段相差的秒数
     3. 如果同一个用户 on-line 记录的下一个不为 off-line 则忽略此 on-line； off-line 同理
     4. 每个用户的区间需要按照从早到晚的顺序依次输出；
     5. 输出格式为: 姓名， 童话所在时间区间
        通电话的区间 每个区间的总秒数 每个区间的开销
        总开销
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] line01 = s.nextLine().split("\\s+");
        for (int i = 0; i < line01.length; i++) {
            prices[i] = Integer.valueOf(line01[i]);
        }

        // 人民和 Person 实例映射
        Map<String, Person> mapper = new HashMap<>();

        // 总查询次数
        int query = Integer.valueOf(s.nextLine());
        for (int i = 0; i < query; i++) {

            String[] line = s.nextLine().split("\\s+");
            String name = line[0];
            String dateTime = line[1];
            String flag = line[2];

            if (!mapper.containsKey(name)) {
                mapper.put(name, new Person());
            }

            Person p = mapper.get(name);
            p.heap.offer(new String[]{dateTime, flag});
        }

        for (String k : mapper.keySet()) {
            mapper.get(k).validatePeriods();
        }

        for (String k : mapper.keySet()) {
            mapper.get(k).printRecords();
        }
    }

    public static double getSumCents(int diff, int endH) {
        double sum = 0.0;
        // TODO: fix cal total cents
        return sum;
    }

    public static double getCentPerMin(int t, int m) {
        return prices[t] * m;
    }

    // 获取时间差，按照秒数
    public static int getMinDiff(String on, String off) {
        int onMins;
        int offMins;
        String[] onTime = on.split(":");
        String[] offTime = off.split(":");
        onMins = monthToDay[Integer.valueOf(onTime[0])] * dayToMin + Integer.valueOf(onTime[1]) * dayToMin
                + Integer.valueOf(onTime[2]) * hourToMin + Integer.valueOf(onTime[3]);
        offMins = monthToDay[Integer.valueOf(offTime[0])] * dayToMin + Integer.valueOf(offTime[1]) * dayToMin
                + Integer.valueOf(offTime[2]) * hourToMin + Integer.valueOf(offTime[3]);
        return offMins - onMins;
    }

    static class Person {

        String name;               // 用户名

        Set<Integer> months = new HashSet<>();        // 有效月份

        List<String[]> periods = new ArrayList<>();    // 所有有效通话的区间

        Double total = 0.0d;    // 所有通话区间的总开销

        String firstCall;    // 首次通话的时间(结果需要按照第一次童话区间从早到晚排序)

        // 按照从早到晚的顺序存储通话区间
        PriorityQueue<String[]> heap = new PriorityQueue<>((a, b) -> {
            String[] atime = a[0].split(":");
            String[] btime = b[0].split(":");
            for (int i = 0; i < 4; i++) {
                if (!atime[i].equals(btime[i])) {
                    return Integer.valueOf(atime[i]) - Integer.valueOf(btime[i]);
                }
            }
            return 0;
        });

        public void printRecords() {
            System.out.print(this.name);
            int h = months.size();
            for (int i = 0; i < h; i++) {
                System.out.print(i);
                if (i != h - 1) {
                    System.out.print(" ");
                }
            }
            for (String[] s : periods) {
                // 分别输出此区间：起始 终止 总秒数 总花费
                System.out.println(String.format("%s %s %d $%0.2f", s[0], s[1], s[2], s[3]));
            }
            // 输出总花费
            System.out.println("Total amount: $" + String.format("0.2f", total));
        }

        // 整理并且返回所有有效的区间, {ontime, offtime, secondsDiff, cost}
        public void validatePeriods() {
            if (heap.isEmpty()) {
                return;
            }
            while (!heap.isEmpty()) {
                String[] top = heap.poll();
                String flag = top[1];
                String[] next;
                if (flag.equals("on-line") && !heap.isEmpty()) {
                    next = heap.peek();
                    if (next[1].equals("off-line")) {
                        String onDate = top[0];
                        if (this.firstCall == null) {
                            firstCall = onDate;
                        }
                        String onMonth = onDate.substring(0, onDate.indexOf(":"));
                        String onTime = onDate.substring(onDate.indexOf(":") + 1);
                        months.add(Integer.valueOf(onMonth));    // 记录通话日期

                        String offDate = next[0];
                        String offMonth = next[0].substring(0, offDate.indexOf(":"));
                        String offTime = offDate.substring(offDate.indexOf(":") + 1);
                        months.add(Integer.valueOf(offMonth));    // 记录通话日期

                        String[] record = new String[4];
                        record[0] = onTime;
                        record[1] = offTime;
                        int diff = getMinDiff(onDate, offDate);
                        record[2] = String.valueOf(diff);

                        // 结束通话的小时数
                        int offH = Integer.valueOf(offTime.substring(0, offTime.indexOf(":")));
                        // 计算该段区间的总开销
                        double cost = getSumCents(diff, offH);
                        record[3] = String.valueOf(cost);
                        total += cost;

                        // 添加有效通话区间，区间总秒数，总金额
                        periods.add(record);
                    }
                }
            }
        }
    }
}

