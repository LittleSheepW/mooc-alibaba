package com.ww.LogLearningAndUsingTheCorrectPosture19;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author: Sun
 * @create: 2019-12-04 10:48
 * @version: v1.0
 */
@Slf4j
public class LogLearningAndUsingTheCorrectPosture19Test {

    static final Logger logger = LoggerFactory.getLogger(LogLearningAndUsingTheCorrectPosture19Test.class);

    /**
     * 打印日志，使用debug追踪方法
     */
    @Test
    public void printLog() {
        logger.trace("Trace Level.");
        logger.debug("Debug Level.");
        logger.info("Info Level.");
        logger.warn("Warn Level.");
        logger.error("Error Level.");
    }

    /**
     * 错误日志形式：
     * 1、用打印语句或log.error( e.printStackTrace(); 这两种打印方式非常不专业，容易造成日志丢失，污染控制日志级别，甚至还可能造成其他问题。
     * 2、占位符误用，此种调用形式对应{@link Logger#info(String, Throwable)}; 最终导致占位符被当做普通字符串处理。
     */
    @Test
    public void placeholderMisuse() {
        try {
            throw new RuntimeException("RuntimeException");
        } catch (RuntimeException e) {
            // 记录伴随消息的INFO级别的异常（可抛出）。
            log.info("错误信息为:", e);
            // 根据指定的格式和参数在INFO级别记录一条消息。
            log.info("错误信息为={}", "sunshine");
        }
    }
}
