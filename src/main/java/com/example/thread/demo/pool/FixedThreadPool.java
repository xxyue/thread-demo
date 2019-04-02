package com.example.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:定长线程池
 * 1、线程池的最大线程数等于核心线程数，并且线程池的线程不会因为闲置超时被销毁。
 *
 * 2、使用的列队是LinkedBlockingQueue，表示如果当前线程数小于核心线程数，那么即使有空闲线程也不会复用线程去执行任务，
 * 而是创建新的线程去执行任务。如果当前执行任务数量大于核心线程数，此时再提交任务就在队列中等待，直到有可用线程。
 * @ClassName: FixedThreadPool
 * @Author: yuexx
 * @Date: 2019/3/1 15:56
 * @Version: 1.0
 */
public class FixedThreadPool {
    public void newFixedThreadPool(){
        //定义ExecutorService
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            //调用execute方法
            cachedThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + ":" + index);
                }
            });

        }

    }

}
