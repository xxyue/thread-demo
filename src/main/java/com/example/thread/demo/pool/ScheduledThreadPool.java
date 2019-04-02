package com.example.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 支持定时的定长线程池
 *
 * 1、该线程池可以设置核心线程数量，最大线程数与newCachedThreadPool一样，都是Integer.MAX_VALUE。
 * 2、该线程池采用的队列是DelayedWorkQueue，具有延迟和定时的作用。
 * @ClassName: ScheduledThreadPool
 * @Author: yuexx
 * @Date: 2019/3/1 16:11
 * @Version: 1.0
 */
public class ScheduledThreadPool {


    public void newScheduledThreadPool(){
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        //延迟三秒执行一次
        ((ScheduledExecutorService) scheduledThreadPool).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟==================");
            }
        },3, TimeUnit.SECONDS);

        //延迟1秒后每个两秒执行一次
        ((ScheduledExecutorService) scheduledThreadPool).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行===============");
            }
        },1,2,TimeUnit.SECONDS);

        //直接执行
        scheduledThreadPool.execute(new Thread(() -> System.out.println("直接执行")));

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
