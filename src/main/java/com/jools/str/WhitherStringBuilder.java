package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 16:26
 * @description: TODO
 */
public class WhitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (String f : fields) {
            result += f;
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder sb = new StringBuilder();
        for (String field : fields) {
            sb.append(field);
        }
        return sb.toString();
    }
}
