package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/7/29 17:22
 * @description: TODO
 */
public class BlackVoteState implements VoteState{
    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        System.out.println("进入了黑名单，将禁止登录和使用本系统");
    }
}
