package main.java.com.jools.stream_;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/3 13:41
 * @description: TODO
 */
public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.out.println("Caught " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.out.println("Caught " + e);
        }
        /*
        输出:
            4月 03, 2025 1:44:21 下午 main.java.com.jools.stream_.LoggingException <init>
            严重: main.java.com.jools.stream_.LoggingException
                at main.java.com.jools.stream_.LoggingExceptions.main(LoggingExceptions.java:17)

            4月 03, 2025 1:44:21 下午 main.java.com.jools.stream_.LoggingException <init>
            严重: main.java.com.jools.stream_.LoggingException
                at main.java.com.jools.stream_.LoggingExceptions.main(LoggingExceptions.java:23)

            Caught main.java.com.jools.stream_.LoggingException
            Caught main.java.com.jools.stream_.LoggingException
        */
    }
}

class LoggingException extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
