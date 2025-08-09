package com.jools.designpattern.state;

public interface VoteState {


    /**
     * 处理状态对应的行为
     *
     * @param user 投票人
     * @param voteItem  投票项
     * @param manager   投票上下文; 用来在实现状态对应的功能处理的时候回调上下文数据
     */
    void vote(String user, String voteItem, VoteManager manager);
}
