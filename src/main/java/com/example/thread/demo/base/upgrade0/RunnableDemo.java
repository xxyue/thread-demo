package com.example.thread.demo.base.upgrade0;

/**
 * @Description:
 *    通过实现Runnable接口来创建线程类
 *  1.Runnable非常适合多个相同线程来处理同一份资源的情况
 *  2.Runnable可以避免由于Java的单继承机制带来的局限
 *  3.如果想获取当前线程句柄，只能用Thread.currentThread()方法
 * @ClassName: RunnableDemo
 * @Author: yuexx
 * @Date: 2019/3/22 10:01
 * @Version: 1.0
 */
public class RunnableDemo implements Runnable {
    private Long sleepTime;

    public RunnableDemo(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名称是：" + Thread.currentThread().getName() +   "  RunnableDemo运行时间--》" + System.currentTimeMillis());
    }
}
