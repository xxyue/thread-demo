package com.example.thread.demo.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 重入锁
 * @ClassName: ReentrantLockDemo
 * @Author: yuexx
 * @Date: 2019/3/28 18:19
 * @Version: 1.0
 */
public class ReentrantLockDemo {
    static Lock lock = new ReentrantLock();//可选择 公平/非公平 重入锁

    private static int count = 0;
    public static void incr(){
        lock.lock();//获得锁
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        count++;
        lock.unlock();//释放锁
    }

    public static int getCount() {
        return count;
    }
}
