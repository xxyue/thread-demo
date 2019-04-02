package com.example.thread.demo.base.upgrade0;

import org.junit.Test;


/**
 * @Description: ${description}
 * @ClassName: RunnableDemoTest
 * @Author: yuexx
 * @Date: 2019/3/22 10:40
 * @Version: 1.0
 */
public class RunnableDemoTest {

    @Test
    public void run() {
        System.out.println("主线程名称 ： " + Thread.currentThread().getName() +  " RunnableDemo 运行时间--》" + System.currentTimeMillis());
        RunnableDemo runnableDemo0 = new RunnableDemo(100L);
        RunnableDemo runnableDemo1 = new RunnableDemo(100L);
        RunnableDemo runnableDemo2 = new RunnableDemo(100L);
        RunnableDemo runnableDemo3 = new RunnableDemo(100L);
        RunnableDemo runnableDemo4 = new RunnableDemo(100L);
        RunnableDemo runnableDemo5 = new RunnableDemo(100L);
        RunnableDemo runnableDemo6 = new RunnableDemo(100L);
        RunnableDemo runnableDemo7 = new RunnableDemo(100L);
        RunnableDemo runnableDemo8 = new RunnableDemo(100L);
        Long startTime = System.currentTimeMillis();
        System.out.println("开始start-->" + startTime);
        new Thread(runnableDemo0).start();
        new Thread(runnableDemo1).start();
        new Thread(runnableDemo2).start();
        new Thread(runnableDemo3).start();
        new Thread(runnableDemo4).start();
        new Thread(runnableDemo5).start();
        new Thread(runnableDemo6).start();
        new Thread(runnableDemo7).start();
        new Thread(runnableDemo8).start();

        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("结束方法-->" + endTime);
        System.out.println("消耗时间" + (endTime - startTime));

    }
}
