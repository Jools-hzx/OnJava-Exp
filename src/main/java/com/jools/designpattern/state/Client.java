package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/7/29 17:31
 * @description: TODO
 */
public class Client {

    public static void main(String[] args) {
        VoteManager vManager = new VoteManager();
        for (int i = 0; i < 8; i++) {
            vManager.vote("u1", " A");
        }

        /*
         输入输出:
            恭喜你投票成功
            请不要重复投票
            请不要重复投票
            请不要重复投票
            你存在恶意刷票行为，取消投票资格
            你存在恶意刷票行为，取消投票资格
            你存在恶意刷票行为，取消投票资格
            进入了黑名单，将禁止登录和使用本系统
        */
    }
}
