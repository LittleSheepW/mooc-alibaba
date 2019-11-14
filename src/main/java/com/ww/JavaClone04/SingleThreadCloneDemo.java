package com.ww.JavaClone04;

import com.ww.JavaClone04.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SingleThreadCloneDemo {

	/**
	 * 只用一个主线程，在主线程中修改订单号分别调用doSomeThing函数，分别打印first和second两个订单编号字符串不会出什么问题。
	 * @param args
	 */
	public static void main(String[] args) {
	    Order order = new Order();
	    order.setOrderNo("first");
		doSomeThing(order);
		order.setOrderNo("second");
		doSomeThing(order);

		// 输出的结果是: first、second
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