package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/7/29 17:18
 * @description: TODO
 */
public class NormalVoteState implements VoteState{

    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        manager.getMapVote().put(user, voteItem);
        System.out.println("恭喜你投票成功");
    }
}
