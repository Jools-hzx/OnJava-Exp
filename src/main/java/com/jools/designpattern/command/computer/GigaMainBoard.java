package com.jools.designpattern.command.computer;

/**
 * @author Jools He
 * @date 2025/7/30 1:44
 * @description: TODO
 */
public class GigaMainBoard implements MainBoardApi{
    @Override
    public void open() {
        System.out.println("技嘉主板现在正在开机，请等候");
        System.out.println("接通电源......");
        System.out.println("设备检查......");
        System.out.println("装载系统......");
        System.out.println("机器正常运转起来......");
        System.out.println("机器已经正常打开，请操作");
    }
}
