package com.ww.JavaClone04;

import com.ww.JavaClone04.entity.Order;
import com.ww.JavaClone04.util.CloneUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MultithreadingCloneUpdateVersionDemo {

    /**
     * 深克隆第二种方式：JDK序列化方式实现深克隆
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Order order = new Order();
        order.setOrderNo("first");
        executorService.execute(() -> doSomeThing(order));

        Order cloneOrder = CloneUtil.deepCloneByJdk(order);
        cloneOrder.setOrderNo("second");
        executorService.execute(() -> doSomeThing(cloneOrder));

        // 输出结果为 first second

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