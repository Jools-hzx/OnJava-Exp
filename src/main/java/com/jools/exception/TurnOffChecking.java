package main.java.com.jools.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/4 21:51
 * @description: TODO
 */

class WrapCheckedException {

    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException("This is FileNotFound Exception");
                case 1:
                    throw new IOException("This is IOException ！！！");
                case 2:
                    throw new RuntimeException("This is RuntimeException!");
                default:
                    return;
            }
        } catch (IOException | RuntimeException e) {
            // 将其修改为非检查型异常
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {
}

public class TurnOffChecking {

    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();

        // 不使用 try 块，直接调用 throwRuntimeException
        // 让 RuntimeException 离开
        wce.throwRuntimeException(3);   // 直接退出

        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    // 大于等于 3 则抛出 SomeOtherException
                    throw new SomeOtherException();
                }
            } catch (SomeOtherException e) {
                // 捕获 SomeOtherException 异常
                System.out.println("SomeOtherException:" + e);
            } catch (RuntimeException e) {
                try {
                    throw e.getCause();
                } catch (FileNotFoundException e1) {    // type = 0 则抛出 FileNotFoundException
                    System.out.println("FileNotFoundException:" + e1);
                } catch (IOException e1) {  // type = 1 则抛出 IOException
                    System.out.println("IOException:" + e1);
                } catch (Throwable e1) {    // type = 2 则抛出 Throwable
                    System.out.println("Throwable:" + e1);
                }
            }

            /*
             输出结果:
                FileNotFoundException:java.io.FileNotFoundException: This is FileNotFound Exception
                IOException:java.io.IOException: This is IOException ！！！
                Throwable:java.lang.RuntimeException: This is RuntimeException!
                SomeOtherException:main.java.com.jools.exception.SomeOtherException
            */
        }
    }
}
