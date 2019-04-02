package com.example.thread.demo.base.safe;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 可见性问题
 * @ClassName: AtomicDemo
 * @Author: yuexx
 * @Date: 2019/3/22 16:25
 * @Version: 1.0
 */
public class VisableDemo {
    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Integer i = 0;
            while (!stop) {
//                synchronized (i){
                    ++i;
//                }

//                System.out.println(stop);
            }
        }, "AtomicDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;

    }
}
