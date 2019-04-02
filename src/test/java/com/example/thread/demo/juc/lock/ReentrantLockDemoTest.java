package com.example.thread.demo.juc.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Description: ${description}
 * @ClassName: ReentrantLockDemoTest
 * @Author: yuexx
 * @Date: 2019/3/28 18:23
 * @Version: 1.0
 */
public class ReentrantLockDemoTest {

    @Test
    public void incr() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread t1 = new Thread(ReentrantLockDemo::incr);
                t1.join();
                t1.start();

            }

            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ReentrantLockDemo.getCount());
    }
}