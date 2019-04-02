package com.example.thread.demo.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 可缓存的线程池
 * newCachedThreadPool的方法中是返回一个ThreadPoolExecutor实例，从源码中可以看出该线程池的特点：
 * 1、该线程池的核心线程数量是0，线程的数量最高可以达到Integer 类型最大值；
 * 2、创建ThreadPoolExecutor实例时传过去的参数是一个SynchronousQueue实例，说明在创建任务时，若存在空闲线程就复用它，没有的话再新建线程。
 * 3、线程处于闲置状态超过60s的话，就会被销毁。
 * @ClassName: CachedThreadPool
 * @Author: yuexx
 * @Date: 2019/3/1 14:15
 * @Version: 1.0T
 */
public class CachedThreadPool {

    public void newCachedThreadPool(){
        //定义ExecutorService
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
//            try {
//                Thread.sleep(1 * 1000);
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
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
