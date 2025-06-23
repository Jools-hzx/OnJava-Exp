package com.jools.reflection;

import java.lang.reflect.Field;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 23:59
 * @description: TODO
 */
public class ModifyingPrivateFields {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        // 尝试访问 private 修饰私有字段
        Field iField = pf.getClass().getDeclaredField("i");
        iField.setAccessible(true);
        System.out.println("f.getInt() :" + iField.getInt(pf));
        // 修改 private 修饰的字段
        iField.set(pf,11111);
        System.out.println(pf);

        /*
         修改 i 字段结果:
            WithPrivateFinalField{i=1, s='I'am totally safe theoritically', s2='Am I safe?'}
            f.getInt() :1
            WithPrivateFinalField{i=11111, s='I'am totally safe theoritically', s2='Am I safe?'}
        */

        // private final 修饰的字段
        Field sField = pf.getClass().getDeclaredField("s");
        sField.setAccessible(true);
        System.out.println("sField.get(pf) :" + sField.get(pf));
        sField.set(pf, "No, you're not! You can be changed!! [Field - s]");
        System.out.println(pf);
        /*
         修改 s 字段结果:
            sField.get(pf) :I'am totally safe theoritically
            WithPrivateFinalField{i=11111, s='I'am totally safe theoritically', s2='Am I safe?'}
        */

        // private 修饰的字段
        Field s2Field = pf.getClass().getDeclaredField("s2");
        s2Field.setAccessible(true);
        System.out.println("s2Field.get(pf) :" + s2Field.get(pf));
        s2Field.set(pf, "No, you're not! You can be changed!! [Field - s2]");
        System.out.println(pf);
        /*
         修改 s2 字段结果:
          s2Field.get(pf) :Am I safe?
          WithPrivateFinalField{i=11111, s='I'am totally safe theoritically', s2='No, you're not! You can be changed!! [Field - s2]'}
        */
    }
}

class WithPrivateFinalField {

    private int i = 1;
    private final String s = "I'am totally safe theoritically";
    private String s2 = "Am I safe?";

    @Override
    public String toString() {
        return "WithPrivateFinalField{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }
}

