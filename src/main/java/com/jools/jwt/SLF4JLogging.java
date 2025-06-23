package com.jools.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/6 17:41
 * @description: TODO
 */
public class SLF4JLogging {

    private static Logger logger = LoggerFactory.getLogger(SLF4JLogging.class);

    public static void main(String[] args) {
        logger.trace("Hello!");
        logger.debug("World!!");
        logger.info("Using");
        logger.warn("SLF4J");
        logger.error("Facade");
        /*
         输出:
            17:47:34.675 [main] DEBUG com.jools.jwt.SLF4JLogging - World!!
            17:47:34.677 [main] INFO com.jools.jwt.SLF4JLogging - Using
            17:47:34.677 [main] WARN com.jools.jwt.SLF4JLogging - SLF4J
            17:47:34.677 [main] ERROR com.jools.jwt.SLF4JLogging - Facade
        */
    }
}
