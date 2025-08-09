package com.jools.designpattern.mediator;

/**
 * @author Jools He
 * @date 2025/7/29 1:13
 * @description: TODO
 */
public class CPU extends Colleague{

    public CPU(Mediator mediator) {
        super(mediator);
    }

    // 分解出来的视频数据
    private String videoData = "";

    // 分解出来的声音数据
    private String soundData = "";

    // 获取分解出来的视频数据
    public String getVideoData() {
        return videoData;
    }

    // 获取分解出来的声音数据
    public String getSoundData() {
        return soundData;
    }

    // 执行分解操作
    public void executeData(String data) {
        String[] strings = data.split(",");
        this.videoData = strings[0];
        this.soundData = strings[1];
        // 通知主板，自己的状态改变了
        getMediator().changed(this);
    }
}
