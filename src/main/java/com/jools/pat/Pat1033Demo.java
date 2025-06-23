package com.jools.pat;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 12:38
 * @description: TODO
 */

import java.util.*;

public class Pat1033Demo {

    static PriorityQueue<Station> stations = new PriorityQueue<>(
            (s1, s2) -> s1.distance.compareTo(s2.distance)
    );

    // 可以抵达的站点; 按照油价顺序从低到高排序
    static PriorityQueue<Station> reached = new PriorityQueue<>(
            (s1, s2) -> s1.price.compareTo(s2.price)
    );

    static String prefix = "The maximum travel distance = ";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split("\\s+");

        // 油箱最大容量、目的地距离、单位消耗可走距离、总城市数目
        double Cmax = Integer.valueOf(line[0]);
        double D = Integer.valueOf(line[1]);
        double Davg = Double.valueOf(line[2]);
        int N = Integer.valueOf(line[3]);

        // 接受所有的站点信息
        for (int i = 0; i < N; i++) {
            String[] next = s.nextLine().split("\\s+");
            double price = Double.valueOf(next[0]);
            int distance = Integer.valueOf(next[1]);
            stations.offer(new Station(price, distance));
        }
        s.close();

        //检查输入
        if (stations.isEmpty()) {
            System.out.println(prefix + "0.00");
            return;
        }

        // 起始站点
        Station start = stations.poll();
        reached.offer(start);

        // 当前最远可达距离、当前花费、当前已达距离、当前站点油价、区间最低站点油价
        double currMax = Davg * Cmax, cost = 0, currDis = 0, price = start.price, minPrice = start.price;
        // 当前油箱剩余油量
        double currC = 0.0;
        // 下一个目标站点
        Station next = null;
        // 起始可达最远距离
        currMax = Davg * Cmax;

        /*
        1.仅有起点加油站，直接输出最远的距离为0，然后结束程序。
        2.当车每到一个站点，记录这个车满油的情况下从当前位置 currDis ~ currMax 所能够到达的所有加油站点;
          之后选择距离最近且价格低于当前站点的加油站前往
        3.如果在满油情况下可以到达的加油站点的油价均高于当前站点，就在当前站点加满油，然后前往这些站点中价格中最低的，
          这样可以保证我所走的每一段路都是价格尽可能的低
        4.如果在满油的情况下，一个加油站都不能到达，那么跳出循环，输出最远能到达的距离，即当前加油站的distance+满油情况下可以跑的距离。
        */
        while (!stations.isEmpty()) {
            while (stations.peek() != null && stations.peek().distance <= currMax) {
                Station peek = stations.poll();
                if (peek.price < minPrice) { // 更新区间相对最低油价
                    next = peek;
                    minPrice = next.price;
                }
                reached.offer(peek);    // 当前站点可达
            }

            // 没有更低价格加油站; 从当前站点加满油后，去到可以抵达的第二最低油价的站点
            System.out.println("***************************************");
            System.out.println("oil before start to reach next station:" + currC);
            if (next == null) {
                next = reached.poll();
                System.out.println("Non lower price station, select relative low station:" + next);
                // 在当前加满油所需价格
                cost += (Cmax - currC) * price;
                // 去到下一个站点所需的油量
                double need = Math.max(0, (Math.min(next.distance, D) - (currDis + currC * Davg)) / Davg);
                System.out.println("Needed oil to reach next station:" + need);
                // 油箱剩余量; 加满油 - 去到价格第二高的油价站点所需油量
                currC = Cmax - need;
            } else {
                // 取到下一个站点所需的油量
                double need = Math.max(0, (Math.min(next.distance, D) - (currDis + currC * Davg)) / Davg);
                // 仅加油加到可以抵达下一个站点
                cost += need * price;
            }

            // 更新，下一回尝试寻找比当前价格更小的站点
            minPrice = next.price;

            // 更新抵达新加油站后的加油新价格
            price = next.price;

            // 更新当前位置为下一个加油站点
            currDis = next.distance;

            // 更新最远可抵达距离; 下一个站点满油状态下的距离
            currMax = currDis + Davg * Cmax;

            System.out.println("Next selected Station:" + next);
            System.out.println("Updated currDis:" + currDis);
            System.out.println("Updated currMax:" + currMax);
            System.out.println("Updated minPrice:" + price);
            System.out.println("Updated cost:" + cost);
            System.out.println("Remain oil after reach station:" + currC);

            // 重置下一个目标站点
            next = null;

            // 剔除所有距离小于当前目标站点位置的可达站点
            Iterator<Station> iterator = reached.iterator();
            while (iterator.hasNext()) {
                Station station = iterator.next();
                if (station.distance <= currDis) {
                    iterator.remove();
                }
            }

            // 抵达目的地
            if (currDis >= D) {
                System.out.printf("%.2f\n", cost);
                break;
            }
        }

        // 通过最后一个站点加油可达
        if (currMax >= D) {
            cost += (D - currDis - currC * Davg) / Davg * price;
            System.out.printf("%.2f\n", cost);
            return;
        }

        // 否则无法抵达; 输出最远可抵达的距离
        if (currDis < D && currMax < D) {
            System.out.println(prefix + String.format("%.2f", currMax));
        }
    }
}

class Station {

    Double price;

    Double distance;

    public Station(double p, double d) {
        this.price = p;
        this.distance = d;
    }

    @Override
    public String toString() {
        return "Station:{ price:" + price + " distance:" + distance + " }";
    }
}
