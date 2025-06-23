package com.jools.assertion;

import com.google.common.base.*;

import static com.google.common.base.Verify.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 21:49
 * @description: TODO
 */
public class GuavaAssertions {

    public static void main(String[] args) {

        Verify.verify(2 + 2 == 4);

        try {
            verify(1 + 2 == 4);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // 校验失败则抛出: VerifyException
            verify(1 + 2 == 4, "Bath math result: %s", " sum is not 4");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;
        try {
            // 抛出 VerifyException
            verifyNotNull(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            // 抛出 VerifyException
            verifyNotNull(s, "Shouldn't be null: %s", "arg 's'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         输出:
            com.google.common.base.VerifyException
            Bath math result:  sum is not 4
            expected a non-null reference
            Shouldn't be null: arg 's'
        */
    }
}
