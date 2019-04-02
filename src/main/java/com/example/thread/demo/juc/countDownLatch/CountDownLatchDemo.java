package com.example.thread.demo.juc.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: （递减）          并行等待并行处理完
 * @ClassName: CountDownLatchDemo
 * @Author: yuexx
 * @Date: 2019/4/1 15:02
 * @Version: 1.0
 */
public class CountDownLatchDemo {


    public void test0(){
        CountDownLatch countDownLatch = new CountDownLatch(3);//初始值
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();  //-1
            System.out.println("Thread 1 : " + countDownLatch.getCount());
        }).start();
        new Thread(() -> {
            System.out.println(2);
            countDownLatch.countDown();
            System.out.println("Thread 2 : " + countDownLatch.getCount());
        }).start();
        new Thread(() -> {
            System.out.println(3);
            countDownLatch.countDown();
            System.out.println("Thread 3 : "+ countDownLatch.getCount());
        }).start();
        try {
            countDownLatch.await();//等待countDownLatch 的计数器为0 之前一直等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕~！");
    }
}
