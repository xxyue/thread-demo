package com.example.thread.demo.base.status;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 查看不同 线程状态
 * @ClassName: ThreadStatusDemo
 * @Author: yuexx
 * @Date: 2019/3/22 14:22
 * @Version: 1.0
 */
public class ThreadStatusDemo {

    /**
     *  查看线程的状态
     * 1. 运行main
     * 2.cmd
     * 3.jps 获得进程的pid (进程名为类名)
     * 4. jstack pid
     * @param args
     */
    public static void main(String[] args) {
        //查看到 TIMED_WAITING 状态
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
       ,"waiting" ).start();

        new Thread(new BlockDemo(),"BlockDemo-0").start();
        new Thread(new BlockDemo(),"BlockDemo-2").start();
    }

    static class BlockDemo extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (BlockDemo.class) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
