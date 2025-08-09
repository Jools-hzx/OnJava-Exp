package com.jools.designpattern.state;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 */
public class VoteManager {

    private VoteState state;

    private Map<String, String> mapVote = new HashMap<>();

    private Map<String, Integer> mapVoteCount = new HashMap<>();

    // 获取记录用户投票结果的 Map
    public Map<String, String> getMapVote() {
        return mapVote;
    }

    // 投票
    public void vote(String user, String voteItem) {
        // 1. 为该用户增加投票的次数
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount == null) {
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        // 2. 判断该用户投票的类型，就相当于是判断对应的状态
        if (oldVoteCount == 1) {
            state = new NormalVoteState();
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            state = new RepeatVoteState();
        } else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            state = new SpiteVoteState();
        } else if (oldVoteCount >= 8) {
            state = new BlackVoteState();
        }

        // 转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }
}
