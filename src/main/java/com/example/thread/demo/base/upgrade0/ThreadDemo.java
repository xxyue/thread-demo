package com.example.thread.demo.base.upgrade0;

/**
 * @Description: 通过继承Thread类来创建线程类
 * @ClassName: ThreadDemo
 * @Author: yuexx
 * @Date: 2019/3/22 9:59
 * @Version: 1.0
 */
public class ThreadDemo extends Thread {
    private Long sleepTime;

    public ThreadDemo(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int print(){
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 当线程类继承Thread类时，直接使用this即可获取当前线程句柄。
        // 因此可以直接调用getName()方法返回当前线程的名称。
        System.out.println("当前线程名称是：" + getName() +  "  ThreadDemoc运行时间--》" + System.currentTimeMillis());
        return 1;
    }

    @Override
    public void run() {
        this.print();
    }

}
