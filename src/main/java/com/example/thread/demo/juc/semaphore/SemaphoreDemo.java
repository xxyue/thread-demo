package com.example.thread.demo.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Semaphore （信号灯）  限流  许可
 * @ClassName: SemaphoreDemo
 * @Author: yuexx
 * @Date: 2019/4/1 17:43
 * @Version: 1.0
 */
public class SemaphoreDemo {
    public void  test0(){
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10 ; i++) {
            new DoAnything(i,semaphore).start();
        }

    }

    static class DoAnything extends Thread {
        private  int num;
        private Semaphore semaphore;

        public DoAnything(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取一个令牌
                System.out.println("第" + num + " 个线程进入");
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();// 释放令牌
                System.out.println("第" + num + "令牌释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
