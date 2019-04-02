package com.example.thread.demo.base.safe;

/**
 * @Description: volatile 的指令重排序
 * @ClassName: VolatileDemo
 * @Author: yuexx
 * @Date: 2019/3/25 11:15
 * @Version: 1.0
 */
public class VolatileDemo2 {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100 ; i++) {
            Thread t1 = new Thread(() -> {
                x = b;
                a = 1;

            });

            Thread t2 = new Thread(() -> {
                y = a;
                b = 1;

            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("x=" + x + "  y=" + y);
        }


    }
}

