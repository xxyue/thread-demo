package com.example.thread.demo.base.upgrade0;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 三个线程按次序执行 join方式
 * @ClassName: JoinDemo
 * @Author: yuexx
 * @Date: 2019/3/26 20:16
 * @Version: 1.0
 */
public class THreadJoinDemo {


    private  volatile int falg = 0;
    /**
     *  三个线程 没有添加任何限制， 顺序是随机的
     */
    public void threeNoJoin() {


        Thread t1 = new Thread(() -> {

            falg += 1;
            System.out.println("t1 -->" + falg);
        });

        Thread t2 = new Thread(() -> {
            falg += 2;
            System.out.println("t2 -->" + falg);
        });

        Thread t3 = new Thread(() -> {
            falg += 4;
            System.out.println("t3 -->" + falg);
        });
            t1.start();
            t2.start();
            t3.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  join 后 按照顺序执行
     * @throws Exception
     */
    public void threeJoin0() throws Exception {


        Thread t1 = new Thread(() -> {
            falg += 1;
            System.out.println("t1 -->" + falg);
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                falg += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("t2 -->" + falg);
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
                falg += 4;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 -->" + falg);
        });
        t1.start();
        t2.start();
        t3.start();
        t3.join();
    }


    /**
     *  添加睡眠时间 验证join 后的顺序
     * @throws Exception
     */
    public void threeJoin1() throws Exception {


        Thread t1 = new Thread(() -> {

            falg += 1;
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("t1 -->" + falg);
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                falg += 2;

                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("t2 -->" + falg);
        });

        Thread t3 = new Thread(() -> {
            try {
                 t2.join();
                 falg += 4;

                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 -->" + falg);
        });
        t1.start();
        t2.start();
        t3.start();
        t3.join();
    }
}
