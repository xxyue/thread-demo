package com.example.thread.demo.base.safe;

/**
 * @Description: 原子性问题
 * @ClassName: AtomicDemo
 * @Author: yuexx
 * @Date: 2019/3/22 16:58
 * @Version: 1.0
 */
public class AtomicDemo {

    private static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1)
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            new Thread(AtomicDemo::inc).start();

        }

        try {
            Thread.sleep(4000);
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
