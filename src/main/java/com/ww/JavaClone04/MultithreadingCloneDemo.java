package com.ww.JavaClone04;

import com.ww.JavaClone04.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MultithreadingCloneDemo {

    /**
     * 多线程环境中，如果我们不通过克隆构造新的对象，线程池中两个线程会公用同一个对象，
     * 后面对订单号的修改将影响到其它线程。
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Order order = new Order();
        order.setOrderNo("first");
        executorService.execute(() -> doSomeThing(order));
        order.setOrderNo("second");
        executorService.execute(() -> doSomeThing(order));

        // 输出的结果是: second、second
    }

    private static void doSomeThing(Order order) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(order.getOrderNo());
    }
}