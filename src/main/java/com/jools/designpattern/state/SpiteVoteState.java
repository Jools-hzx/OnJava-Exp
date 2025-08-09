package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/7/29 17:20
 * @description: TODO
 */
public class SpiteVoteState implements VoteState{
    @Override
    public void vote(String user, String voteItem, VoteManager manager) {

        String s = manager.getMapVote().get(user);
        if(s != null) {
            manager.getMapVote().remove(user);
        }
        System.out.println("你存在恶意刷票行为，取消投票资格");
    }
}
