package com.example.thread.demo.pool;

/**
 *  线程池
 *
 * newCachedThreadPool 可缓存的线程池
 *  * newCachedThreadPool的方法中是返回一个ThreadPoolExecutor实例，从源码中可以看出该线程池的特点：
 *  * 1、该线程池的核心线程数量是0，线程的数量最高可以达到Integer 类型最大值；
 *  * 2、创建ThreadPoolExecutor实例时传过去的参数是一个SynchronousQueue实例，说明在创建任务时，若存在空闲线程就复用它，没有的话再新建线程。
 *  * 3、线程处于闲置状态超过60s的话，就会被销毁。
 *
 *  newFixedThreadPool  定长线程池
 *   * 1、线程池的最大线程数等于核心线程数，并且线程池的线程不会因为闲置超时被销毁。
 *  * 2、使用的列队是LinkedBlockingQueue，表示如果当前线程数小于核心线程数，那么即使有空闲线程也不会复用线程去执行任务，
 *  * 而是创建新的线程去执行任务。如果当前执行任务数量大于核心线程数，此时再提交任务就在队列中等待，直到有可用线程。
 *
 *  SingleThreadExecutor　单线程线程池
 *  从源码就可以看出，该线程池基本就是只有一个线程数的newFixedThreadPool，它只有一个线程在工作，所有任务按照指定顺序执行。
 *
 *  newScheduledThreadPool　支持定时的定长线程池
 *  * 1、该线程池可以设置核心线程数量，最大线程数与newCachedThreadPool一样，都是Integer.MAX_VALUE。
 *  * 2、该线程池采用的队列是DelayedWorkQueue，具有延迟和定时的作用。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
