package com.ww.LogLearningAndUsingTheCorrectPosture19;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDemo {

    /**
     * 源码中直接将两个字符串字面量进行拼接，编译时期就会生成新的字符串
     */
    public void first() {
        log.debug("慕课" + "专栏");
        log.debug("[v1:{}] [v2:{}] [v3:{}]", "s", "u", "n");
    }

    public void second(String website) {
        log.debug("慕课网" + website);

    }

    public void third(String website) {
        /**
         * 如果不加入判断，会因为字符串拼接造成不必要的资源损耗
         * 但是如果每个日志打印都加_上这种判断，代码非常不优雅，因此常见的实现了org.slf4j.Logger接口的日志框架提供了占位符日志打印方法。
         * 使用占位符的方式，底层会先使用判断逻辑，再去拼接字符串，从而避免了不必要的字符串拼接。
         */
        if (log.isDebugEnabled()) {
            log.debug("慕课网" + website);
        }
    }


    // -------------------------------以上代码经过反汇编后逆向翻译的代码------------------------------- //

    public void firstDisassembly() {
        log.debug("慕课专栏");
    }

    public void secondDisassembly(String website) {
        StringBuilder builder = new StringBuilder();
        builder.append("慕课网");
        builder.append(website);
        String result = builder.toString();
        log.debug(result);
    }

    public void thirdDisassembly(String website) {
        if (!log.isDebugEnabled()) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("慕课网");
        builder.append(website);
        String result = builder.toString();
        log.debug(result);
    }
}