package com.jools.str;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/8 17:48
 * @description: TODO
 */
public class TextBlocks {

    public static final String OLD = "Yesterday, all my troubles seemed so far away.\n" +
            "Now it looks as though they're here to stay.\n" +
            "Oh, I believe in yesterday.\n" +
            "Suddenly I'm not half the man I used to be.\n" +
            "There's a shadow hanging over me.\n" +
            "Oh, yesterday came suddenly.\n";

    public static final String NEW = """
            Yesterday, all my troubles seemed so far away.
            Now it looks as though they're here to stay.
            Oh, I believe in yesterday.
            Suddenly I'm not half the man I used to be.
            There's a shadow hanging over me.
            Oh, yesterday came suddenly.
            """;

    public static void main(String[] args) {
        System.out.println(OLD.equals(NEW));    // true
    }
}
