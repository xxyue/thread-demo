package com.example.thread.demo.base.upgrade0;

import java.util.concurrent.Callable;

/**
 * @Description: 线程实现
 * @ClassName: CallatbleDemo
 * @Author: yuexx
 * @Date: 2019/3/21 18:51
 * @Version: 1.0
 */
public class CallableDemo implements Callable<String> {

    private Long sleepTime;

    public CallableDemo(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(sleepTime);
        System.out.println("当前线程名称是：" + Thread.currentThread().getName() +   "  CallableDemo运行时间--》" + System.currentTimeMillis());
        return "Callable 功能测试--> " + System.currentTimeMillis();
    }
}
