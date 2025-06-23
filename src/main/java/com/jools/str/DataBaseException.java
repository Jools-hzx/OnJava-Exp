package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:34
 * @description: TODO
 */
public class DataBaseException extends Exception {

    public DataBaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DataBaseException(3, 7, "File not found");
        } catch (Exception e) {
            System.out.println(e);  // 输出: com.jools.str.DataBaseException: (t3, q7) File not found
        }
    }
}
