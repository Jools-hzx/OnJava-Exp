package com.jools.enum_;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 17:44
 * @description: TODO
 */
public class EnumMaps {


    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> eMap = new EnumMap<>(AlarmPoints.class);

        // 匿名内部类实现 Command 接口； Lambda 表达式简化
        eMap.put(AlarmPoints.KITCHEN, () -> System.out.println("Kitchen fire!"));
        eMap.put(AlarmPoints.BATHROOM, () -> System.out.println("Bathroom alert!"));
        eMap.put(AlarmPoints.LOBBY, () -> System.out.println("Lobby alert!"));

        for (Map.Entry<AlarmPoints, Command> entry : eMap.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            entry.getValue().execute();
        }

        try {
            eMap.get(AlarmPoints.START1).execute();
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
         输出结果:
         LOBBY - Lobby alert!
            BATHROOM - Bathroom alert!
            KITCHEN - Kitchen fire!
            java.lang.NullPointerException: Cannot invoke "com.jools.enum_.Command.execute()" because the return value of
            "java.util.EnumMap.get(Object)" is null
        */
    }
}

interface Command {
    void execute();
}
