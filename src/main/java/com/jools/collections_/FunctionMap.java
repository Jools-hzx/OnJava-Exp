package com.jools.collections_;

import java.util.Map;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 15:51
 * @description: TODO
 */
public class FunctionMap {

    public static void main(String[] args) {
        // 注意使用的是 Map.Entry 对象; 且这个 Set 包含了 stream() 和 parallelStream() 方法
        HTMLColors.MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(v -> v.startsWith("Dark"))
                .map(v -> v.replaceFirst("Dark", "Hot"))
                .forEach(System.out::println);
        /*
         输出结果:
            HotBlue
            HotCyan
            HotGoldenRod
            HotGray
            HotGreen
            HotKhaki
            HotMagenta
            HotOliveGreen
            HotOrange
            HotOrchid
            HotRed
            HotSalmon
            HotSeaGreen
            HotSlateBlue
            HotSlateGray
            HotTurquoise
            HotViolet
        */
    }
}
