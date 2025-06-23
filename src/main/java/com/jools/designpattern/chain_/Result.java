package com.jools.designpattern.chain_;

import java.util.Collections;
import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/22 22:38
 * @description: TODO
 */
public class Result {

    public final boolean success;
    public final List<Double> line;

    // 构造器 - 设置数据
    public Result(List<Double> line) {
        success = true;
        this.line = line;
    }

    // 无参构造器 - 默认空数据
    private Result() {
        success = false;
        line = Collections.emptyList();
    }

    public static final Result FAIL = new Result();
}
