package com.jools.pat;

import java.util.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 10:41
 * @description: N 个桌子: 编号为 1 ~ N
 * 规则: 1. 如果有客人达到后存在桌子空闲，则按照编号从小到达的顺序分配左子
 * 2. 如果所有桌子都已经被占满则等待
 * 3. 假设每一个人员使用桌子最多为 2 小时
 * 4. 当贵宾桌开放时，队列中的第一对贵宾将有权使用它。然而，如果队列中没有贵宾，下一对玩家可以使用它。
 * 5. 另一方面，如果轮到一对贵宾但没有贵宾桌可用，他们可以被当作普通玩家分配。
 * 6. 开门营业时间: 08:00:00 ~ 21:00:00
 * 7. 每个顾客的等待时间必须向上取整为整数分钟
 * 要求: 计算每个人等待队列的时长
 * <p>
 * 输入: 第一行 N 表示 N 个 players
 * 第二行开始包含: HH:MM:SS 表示达到时间 P 表示这对 player 所需的使用时长  tag 为 1 表示为 VIP 否则不是
 * 最终有两个正整数 K 表示 tables 的数目 M 表示 VIP 桌子的数目
 * 以下是玩家信息，后面有两个正整数:
 * 1. K（≤100）——桌子数量
 * 2. M（＜K）——贵宾桌数量。
 * 3. 最后一行包含 M 个桌号。
 * <p>
 * 输出要求:
 * 抵达时间 + 使用时间 + 等待时间
 * 之后按照编号的顺序输出每张桌子服务玩家的时间 (按照服务时间的从长到短的顺序)
 * 如果存在关闭时间前无法服务的 player 则不输出
 */
public class Pat1026TableClubDemo {

    //开门营业时间
    private static final int OPEN = 8 * 60 * 60;

    // 关门时间
    private static final int CLOSE = 21 * 60 * 60;

    // 最长使用时长
    private static final int MAX_SERVE = 120 * 60;

    // 优先队列，按照抵达时间存储所有普通客户; 如果相同时间抵达，VIP 客户享有优先权
    private static List<Player> players = new ArrayList<>();

    // 存储所有普通桌子，下标通过 no 获取; 按照 freeTime 从小到大排序
    private static PriorityQueue<Player> tables = new PriorityQueue<>(
            (p1, p2) -> p1.freeTime - p2.freeTime
    );
    // 存储所有的 VIP 桌子，通过 no 获取下标，记录服务时长; 按照 freeTime 从小到大排序
    private static PriorityQueue<Player> vipTables = new PriorityQueue<>(
            (p1, p2) -> p1.freeTime - p2.freeTime
    );

    // 总桌子数目 K 个
    private static int K;

    // M 个 VIP 队列
    private static int M;

    // 队列数目
    private static int Q;

    // 每个桌子的服务人员数目, 下标 0 ~ N - 1 表示普通桌子，N - 1 ~ K - 1 表示 VIP 桌子
    private static int[] serveNums;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        for (int i = 0; i < N; i++) {
            String[] info = s.nextLine().split(" ");
            boolean isVip = info[2].equals("1");
            int arrive = getSeconds(info[0]);
            // 已经关门
            if (arrive > CLOSE) {
                continue;
            }
            // 所有时间转换为 秒数
            Player p = new Player(arrive, Integer.valueOf(info[1]) * 60, isVip);
            players.add(p);
        }

        // 按照抵达时间从早到晚排序
        Collections.sort(players, (p1, p2) -> {
            return p1.arriveTime - p2.arriveTime;
        });

        System.out.println("----- Initializing -----");
        for (Player player : players) {
            System.out.println(player);
        }

        // 桌子信息
        String[] next = s.nextLine().split(" ");

        // 总桌子数目
        K = Integer.valueOf(next[0]);

        // VIP 桌子总数
        M = Integer.valueOf(next[1]);

        // 普通桌子的数目
        Q = Integer.valueOf(s.nextLine());

        // 初始化所有桌子, 0 ~ K - M - 1 为普通桌子；K - M - 1 ~ K - 1 为 VIP 桌面
        serveNums = new int[K];
        s.close();

        // 先初始化分配所有的桌子; 如果此用户为 VIP 并且 VIP 桌子空闲，则优先分配给 VIP 桌子
        int nextVip = K - M;
        int nextOrd = 0;
        for (int i = 0; i < K; i++) {
            Player poll = players.remove(0);
            // 更新使用结束时间
            poll.freeTime = poll.arriveTime + Math.min(poll.serveTime, MAX_SERVE);
            // 更新开始使用时间
            poll.startTime = Math.max(OPEN, poll.arriveTime);
            // 如果早到，需要等待开门；否则直接分配
            poll.waitTime = Math.max(OPEN - poll.arriveTime, 0);

            // 若为 VIP 并且 VIP 桌面有空闲，分配 VIP
            if (poll.tag && vipTables.size() < M) {
                vipTables.offer(poll);
                // 以当前 i 作为分配的 table no
                poll.tableNo = nextVip;
                // 服务用户数 + 1
                serveNums[nextVip++]++;
                continue;
            }
            // 否则分配给普通桌子
            if (tables.size() < (K - M)) {
                poll.tableNo = nextOrd;
                serveNums[nextOrd++]++;
                tables.offer(poll);
            }
        }

        System.out.println(">>>> Initializing ordianry tables....");
        for (Player tp : tables) {
            System.out.println(tp);
        }
        System.out.println(">>>> Initializing vip tables");
        for (Player vip : vipTables) {
            System.out.println(vip);
        }


        /*
         分配规则
         规则:
         1. 如果有客人达到后存在桌子空闲，则按照编号从小到达的顺序分配左子
         2. 如果所有桌子都已经被占满则等待
         3. 假设每一个人员使用桌子最多为 2 小时
         4. 当贵宾桌开放时，队列中的第一对贵宾将有权使用它。然而，如果队列中没有贵宾，下一对玩家可以使用它。
         5. 另一方面，如果轮到一对贵宾但没有贵宾桌可用，他们可以被当作普通玩家分配。
         6. 开门营业时间: 08:00:00 ~ 21:00:00
         7. 每个顾客的等待时间必须向上取整为整数分钟
         8. 每次派发 M 个桌号; 如果后续等待的 M 个顾客含有 VIP 顾客，优先分配 VIP 顾客
        */

        // 统计各个 Player 的结果
        List<Player> ans = new ArrayList<>();
        while (!players.isEmpty()) {
            /*
              后续的 Player 按照抵达时间分配；
              如果该 Player 为 VIP 并且当前 vipTables 中 peek.freeTime <= Player.arriveTime 则分配给 VIP
              否则将其分配给普通桌子
            */
            Player finish;
            Player nextPlayer;
            // 比较是 VIP 桌台先空缺还是普通位置先空缺
            boolean dispatchVip = vipTables.peek().freeTime < tables.peek().freeTime;
            finish = dispatchVip ? vipTables.poll() : tables.poll();
            System.out.println(">>> Finish Player:" + finish);
            // 安排下一个抵达顾客
            nextPlayer = getNextPlayer(players, finish.freeTime, finish.tag);

            // 记录上一个 Player 的 startTime freeTime 和 等待时长
            ans.add(finish);
            // 更新此 Player 的等待时长：当前队列上一次处理完时间 - 当前Player抵达时间
            nextPlayer.waitTime = Math.max(finish.freeTime - nextPlayer.arriveTime, 0);
            // 更新开始时间: 当前用户的抵达时间 + 等待时间
            nextPlayer.startTime = nextPlayer.arriveTime + nextPlayer.waitTime;
            // 更新结束时间: 当前用户的开始时间 + 服务时间 (最多使用 2 小时)
            nextPlayer.freeTime += nextPlayer.startTime + Math.min(MAX_SERVE, nextPlayer.serveTime);

            // 标记该用户使用的桌台编号
            nextPlayer.tableNo = finish.tableNo;
            // 特殊情况: 超过关门时间不计算; 该桌台服务人数 + 1
            if (nextPlayer.freeTime <= CLOSE) {
                serveNums[nextPlayer.tableNo]++;
            }

            // 分配给 VIP table 还是普通
            if (dispatchVip) {
                vipTables.offer(nextPlayer);
            } else {
                tables.offer(nextPlayer);
            }
        }

        // 普通桌台继续服务完
        while (!tables.isEmpty()) {
            Player nextFinish = tables.poll();
            serveNums[nextFinish.tableNo]++;
            ans.add(nextFinish);
        }
        // VIP 桌台服务完
        while (!vipTables.isEmpty()) {
            Player nextFinish = vipTables.poll();
            serveNums[nextFinish.tableNo]++;
            ans.add(nextFinish);
        }

        // 需要按照每个 Player 的开始 serve 时间从早到晚排序; 如果开始服务时间一致，按照抵达时间从早到晚排序
        Collections.sort(ans, (p1, p2) -> {
            if (p1.startTime != p2.startTime) {
                return p1.startTime - p2.startTime;
            }
            return p1.arriveTime - p2.arriveTime;
        });

        //输出各个 Player: 按照 抵达时间 开始使用时间 等待时长(分钟);
        for (Player p : ans) {
            if (p.startTime > CLOSE) continue;   // 关门后不显示
            System.out.printf("%s %s %s\n",
                    toFormatTime(p.arriveTime),
                    toFormatTime(p.startTime),
                    roundUpToMin(p.waitTime));
        }

        // 每个桌子按照服务人数从多到少排序
        Arrays.sort(serveNums);
        StringBuilder sb = new StringBuilder();
        for (int i = serveNums.length - 1; i >= 0; i--) {
            sb.append(serveNums[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static String toFormatTime(int t) {
        int h = t / 3600;
        int m = (t - h * 3600) / 60;
        int s = t - 3600 * h - m * 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    // 将秒转换为分钟，并且向上取整
    static int roundUpToMin(int sec) {
        return sec % 60 == 0 ? sec / 60 : sec / 60 + 1;
    }

    // 将时间字符串转换为秒
    static int getSeconds(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 * 60 +
                Integer.valueOf(times[1]) * 60 +
                Integer.valueOf(times[2]);
    }

    // 按照VIP优先级返回队列内下一个服务的 Player
    static Player getNextPlayer(List<Player> players, int freeTime, boolean vip) {
        // 不是 VIP 位置空缺
        if (!vip) {
            return players.remove(0);
        }
        // 如果是 VIP 位置发生空缺，返回排队的 VIP 顾客
        int remain = players.size();
        for (int i = 0; i < Q && i < remain; i++) {
            Player next = players.get(i);
            // 抵达时间晚于空缺时间
            if (next.arriveTime > freeTime) break;
            if (vip && next.tag) {
                players.remove(next);
                return next;
            }
        }
        // 默认选取下一个最早抵达
        return players.remove(0);
    }
}

// 用户
class Player {

    // 分配的 Table 编号
    int tableNo;
    // 用户抵达时间
    int arriveTime;
    // 用户要求服务时长
    int serveTime;
    // 用户实际开始时长
    int startTime;
    // 用户结束时长
    int freeTime;
    // 用户等待时长
    int waitTime;
    // 标记用户是否是 VIP
    boolean tag;

    public Player(int arriveTime, int serveTime, boolean tag) {
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Player{" +
                "tableNo=" + tableNo +
                ", arriveTime=" + Pat1026TableClubDemo.toFormatTime(arriveTime) +
                ", serveTime=" + serveTime +
                ", startTime=" + Pat1026TableClubDemo.toFormatTime(startTime) +
                ", freeTime=" + Pat1026TableClubDemo.toFormatTime(freeTime) +
                ", waitTime=" + waitTime +
                ", tag=" + tag +
                '}';
    }
}
