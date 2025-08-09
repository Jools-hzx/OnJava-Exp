package com.jools.designpattern.command.cook;

/**
 * @author Jools He
 * @date 2025/7/30 2:20
 * @description: TODO
 */
public class PorkCommand implements Command{
    /**
     * 持有具体做菜的厨师的对象
     */
    private CookApi cookApi = null;
    /**
     * 设置具体做菜的厨师的对象
     * @param cookApi 具体做菜的厨师的对象
     */
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook("蒜泥白肉");
    }
}
