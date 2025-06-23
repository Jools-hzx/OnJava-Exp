package com.jools.enum_;

import cn.hutool.crypto.symmetric.DES;

import java.util.EnumMap;

import static com.jools.enum_.Outcome.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/29 22:49
 * @description: TODO
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<>(RoShamBo5.class);

    static {
        // 初始化所有 RoShamBo5 枚举实例
        for (RoShamBo5 it : RoShamBo5.values()) {
            table.put(it, new EnumMap<>(RoShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(ROCK, LOSE, WIN, DRAW);
        initRow(SCISSORS, WIN, DRAW, LOSE);
    }

    // 对于每个枚举实例，建立比赛结果和传入枚举实例的映射 DRAW WIN LOSE 三种结果分别绑定的枚举实例
    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSOR, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> outComeMap = RoShamBo5.table.get(it);
        outComeMap.put(PAPER, vPAPER);
        outComeMap.put(SCISSORS, vSCISSOR);
        outComeMap.put(ROCK, vROCK);
    }

    // 获取对手出实例 competitor 对比 this 的比赛结果
    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 5);
    }
}
