package com.ww.SomeExceptionHandlingSuggestions18;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("ab");
        data.add("abc");

//        printList1(data, executorService);
//        printList2(data, executorService);

        printList2change(data, executorService);


    }

    /**
     * for循环在线程池执行代码外部，每次循环调用线程池去执行判断和打印语句
     * 此时依次传入a、ab、abc、abcd四个字符串;当执行到ab时会抛出IllegalArgumentException，此时线程池中的唯一的线程销毁;当执行到abc字符串时，线程池
     * 再次创建新的线程来执行，依然可以正常执行。
     *
     * @param data
     * @param executorService
     */
    private static void printList1(List<String> data, ExecutorService executorService) {
        for (String str : data) {
            executorService.execute(() -> {
                // 模拟中间报错
                if (str.length() == 2) {
                    throw new IllegalArgumentException();
                }
                System.out.println(str);
            });
        }
    }

    /**
     * for循环在线程池execute参数的lambda表达式内，所有的循环执行都在同一个线程内。当执行到ab字符串时，抛出了异常，导致整个线程销毁，无法继续执行。
     *
     * @param data
     * @param executorService
     */
    private static void printList2(List<String> data, ExecutorService executorService) {
        executorService.execute(() -> {
            for (String str : data) {
                // 模拟中间报错(一个数据出错后续代码均无法执行)
                if (str.length() == 2) {
                    throw new IllegalArgumentException();
                }
                System.out.println(str);
            }
        });
    }

    /**
     * 防止一个数据出错导致后续所有代码都无法执行
     *
     * @param data
     * @param executorService
     */
    private static void printList2change(List<String> data, ExecutorService executorService) {
        executorService.execute(() -> {
            for (String str : data) {
                try {
                    // 模拟中间报错
                    if (str.length() == 2) {
                        throw new IllegalArgumentException();
                    }
                    System.out.println(str);
                } catch (Exception e) {
                    log.error("程序出错，参数data:{},错误详情", ExceptionUtils.getStackTrace(e), e);
                }
            }
        });
    }
}