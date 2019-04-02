package com.example.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 单线程线程池
 * 从源码就可以看出，该线程池基本就是只有一个线程数的newFixedThreadPool，它只有一个线程在工作，所有任务按照指定顺序执行。
 * @ClassName: SingleThreadExecutor
 * @Author: yuexx
 * @Date: 2019/3/1 16:07
 * @Version: 1.0
 */
public class SingleThreadExecutor {

    public void newSingleThreadExecutor(){
        //定义ExecutorService
        ExecutorService cachedThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
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
