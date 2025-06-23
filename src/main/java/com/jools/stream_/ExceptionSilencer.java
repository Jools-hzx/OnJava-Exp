package main.java.com.jools.stream_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 15:41
 * @description: TODO
 */
public class ExceptionSilencer {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // 如果在 finally 块中使用 return; 会将任何被抛出的异常都压制下来
            return;
        }
    }
}
