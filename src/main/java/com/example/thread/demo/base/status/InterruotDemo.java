package com.example.thread.demo.base.status;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程终止
 * @ClassName: InterruotDemo
 * @Author: yuexx
 * @Date: 2019/3/22 14:47
 * @Version: 1.0
 */
public class InterruotDemo {
    private static int i;
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
                System.out.println(i);
            }
            System.out.println(i);
        },"interruotDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//设置interrupt 标识为true; 终止线程
        System.out.println("*********** befor1 + " + thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        thread.interrupted();//Thread.interrupted(); 复位
        System.out.println("********** after1 + " + thread.isInterrupted());

    }
}
