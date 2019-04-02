package com.example.thread.demo.pool;

import java.util.concurrent.*;

/**
 * @Description: 自定义线程池1
 * @ClassName: MyThreadPool
 * @Author: yuexx
 * @Date: 2019/4/2 14:11
 * @Version: 1.0
 */
public class MyThreadPool {

    /**
     * int corePoolSize,//核心线程数
     *  int maximumPoolSize,  //最大线程数
     * long keepAliveTime, //超时时间，  超出核心线程数量以外的空余线程的存活时间
     * TimeUnit unit,  //存活时间单位
     * BlockingQueue<Runnable> workQueue, //阻塞队列
     * hreadFactory threadFactory,  //
     * RejectedExecutionHandler handler) { //reject 操作，  超出最大线程数的，拒绝的操作
     *
     * 自定义一个线程池
     *  核心数10  最大 30  存活时间为 100秒， 存活队列
     */
    static ExecutorService executorService = new ThreadPoolExecutor(10,30,
            100L,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(70),new MyRejectedExecutionHandler());

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        /**
         * 自定义的 超过最大线程数 打印日志，然后直接跑出异常
         * @param r
         * @param executor
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("超过最大线程数！");
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    executor.toString());
        }
    }
}
