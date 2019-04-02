package com.example.thread.demo.pool;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description: 自定义线程池工具
 * @ClassName: MyExecutors
 * @Author: yuexx
 * @Date: 2019/4/2 16:33
 * @Version: 1.0
 */
public class MyExecutors extends ThreadPoolExecutor {

    //beforExecutor、  afterExecutor、 shetdown  // 用于扩展

       //1.时间统计
        private Map<String, Date> startTimes;

    public MyExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.startTimes = new ConcurrentHashMap<String, Date>();
    }

    public MyExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    public void shutdown() {
        System.out.println("已经执行的任务数量 ： " + this.getCompletedTaskCount() + "\n");
        System.out.println("当前活动的线程数 ： " + this.getActiveCount() + "\n");
        System.out.println("当前排队的线程数 ： " + this.getQueue().size() + "\n");
        super.shutdown();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimes.put(String.valueOf(r.hashCode()), new Date());//放入开始执行时间
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date startTime = startTimes.remove(String.valueOf(r.hashCode()));
        Date finishDate = new Date();
        long dif = finishDate.getTime() - startTime.getTime();
        System.out.println("任务耗时 ： " +  dif);
        System.out.println("最大允许的线程数" + this.getMaximumPoolSize());
        System.out.println("线程空闲时间" + this.getKeepAliveTime(TimeUnit.MICROSECONDS));
        System.out.println("任务总数" + this.getTaskCount());
        super.afterExecute(r, t);
    }

    /**
     * 增强的 CachedThreadPool
     * @return
     */
    public  static ExecutorService newMyCachedThreadPool(){
        return new MyExecutors(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    public static void main(String[] args){
        ExecutorService executorService = MyExecutors.newMyCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new Thread(() ->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行！！！！！");
            }));
        }
    }
}
