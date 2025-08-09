package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/7/29 17:19
 * @description: TODO
 */
public class RepeatVoteState implements VoteState{
    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        // 重复投票不做处理
        System.out.println("请不要重复投票");
    }
}
