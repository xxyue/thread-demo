package com.example.thread.demo.base.upgrade0;

import org.junit.Test;

/**
 * @Description: ${description}
 * @ClassName: ThreadDemoTest
 * @Author: yuexx
 * @Date: 2019/3/22 10:10
 * @Version: 1.0
 */
public class ThreadDemoTest {

    /**
     *  证明所有线程是并行执行的
     */
    @Test
    public void run() {
        // 通过Thread.currentThread获取当前线程句柄
        System.out.println("主线程名称 ： " + Thread.currentThread().getName());

        ThreadDemo threadDemo0 = new ThreadDemo(100L);
        ThreadDemo threadDemo1 = new ThreadDemo(100L);
        ThreadDemo threadDemo2 = new ThreadDemo(100L);
        ThreadDemo threadDemo3 = new ThreadDemo(100L);
        ThreadDemo threadDemo4 = new ThreadDemo(100L);
        ThreadDemo threadDemo5 = new ThreadDemo(100L);
        ThreadDemo threadDemo6 = new ThreadDemo(100L);
        ThreadDemo threadDemo7 = new ThreadDemo(100L);
        ThreadDemo threadDemo8 = new ThreadDemo(100L);
        Long startTime = System.currentTimeMillis();
        System.out.println("开始start-->" + startTime);
        threadDemo0.start();
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
        threadDemo4.start();
        threadDemo5.start();
        threadDemo6.start();
        threadDemo7.start();
        threadDemo8.start();
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