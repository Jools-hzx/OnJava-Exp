package com.jools.designpattern.interpreter;

import java.util.StringTokenizer;

/**
 * @author Jools He
 * @date 2025/7/30 3:47
 * @description: TODO
 */
public class Context {

    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        this.tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning:" + token + " is expected, but " + currentToken + " is found");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning:" + currentToken + " is not a number");
        }
        return number;
    }
}
