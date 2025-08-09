package com.jools.designpattern.command.cook;

/**
 * @author Jools He
 * @date 2025/7/30 2:17
 * @description: TODO
 */
public class Waiter {

    /**
     * 持有一个宏对象 - 菜单
     */
    private MenuCommand menuCommand = new MenuCommand();

    /**
     * 客户点菜
     */
    public void orderDish(Command cmd) {
        CookApi hotCook = new HotCook();
        CookApi coolCook = new CoolCook();
        //判读到底是组合凉菜师傅还是热菜师傅
        //简单点根据命令的原始对象的类型来判断
        if(cmd instanceof DuckCommand){
            ((DuckCommand)cmd).setCookApi(hotCook);
        }else if(cmd instanceof ChopCommand){
            ((ChopCommand)cmd).setCookApi(hotCook);
        }else if(cmd instanceof PorkCommand){
            //这是个凉菜，所以要组合凉菜的师傅
            ((PorkCommand)cmd).setCookApi(coolCook);
        }
        //添加到菜单中
        menuCommand.addCommand(cmd);
    }

    // 点菜完毕后
    public void orderOver() {
        this.menuCommand.execute();
    }
}
