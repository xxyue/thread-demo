/**
 *
 *
 *  线程是实现java
 *  Thread / Tunnable / Callable.Future
 *
 *  并发变成的基础
 *  1.线程状态 (6种)
 *         NEW (初始状态，没有调用start方法)
 *         RUNNABLE （运行状态）
 *         BLOCKED （阻塞状态）
 *                  1.等待阻塞 wait
 *                  2.同步阻塞(synchronized)
 *                  3.其他阻塞 （sleep/join）
 *         WAITING  （等待）
 *         TIMED_WAITING （时间等待）
 *         TERMINATED （终止）
 *
 *  2.线程的启动，线程的终止
 *      启动 -- start native方法
 *
 *      终止 -- stop(不建议只用 直接kill 可能导致一些不可预测后果)
 *          interrupt( 优雅终止)
 *          通过指令的方式（volatile boolean isStop = false）
 *
 *  3.线程的安全问题
 *          可见性，原子性，有序性 问题
 *          volatile/synchronized/final/juc(java.util.concurrent)
 *
 *          原子性
 *          synchronized(monitorenter/monitorexit 指令)
 *
 *          可见性
 *          volatile、synchronized、final
 *
 *          有序性
 *          volatile、synchronized
 *
 *
 *       原理：
 *
 *              volatile (可以理解为 轻量级的锁)
 *                  1.解决可见性（lock）
 *                  2.防止指令重排  (内存屏障)
 *                  无法保证复合操作的原子性
 *
 *              synchronized：
 *                     可见性，原子性，有序性
 *                      monitorenter/monitorexit
 *
 *
 *
 *
 *
 *
 *
 *
 *  4.JMM内存模型（图https://www.processon.com/diagraming/5c453433e4b0641c83e35ed3）
 *
 * 指令重排
 *  CPU解决指令重排序
 *  *                  内存屏障，优化屏障
 *  *
 *  *                  内存屏障：
 *  *                  store barrier（写屏障 storestore barrier 强制所有在storestore内存屏障之前的所有指令执行、发送缓存失效的指令，所有在sororestore内存之后的store指令，必须在storestore内存你屏障之前的指令执行之后再执行）
 *  *                  load barrier （度屏障 loadload barrier  强制所有在loadload内存屏障之前的所有指令执行、）
 *  *                  full barrier
 *  *                  作用
 *  *                   防止指令之间重排
 *  *                   保证数据的可见性
 *
 *  JMM解决指令重排徐
 *                  loadload barrier
 *                  storestore barrier
 *                  storeload barrier
 *                  loadstore barrier
 *
 *     对每个volatile写操作前面插入storestore barrier
 *     对每个volatile写操作后面插入storeload barrier
 *     对每个volatile读操作前面插入loadload barrier
 *     对每个volatile读操作后面面插入loadstore barrier
 *
 *
 *  原子性
 *  synchronized
 *  AtomicInteger (CAS)、Lock(CAS/LockSupport/AQS/unsafe)
 *
 *  锁的状态
 *  偏向锁 01
 *   轻量级锁 00
 *   重量级锁 10
 *
 *
 *
 *  锁的获取过程
 *  自旋锁
 *   for(;;){
 *       获取锁
 *   }
 *
 *
 * 偏向锁 01
 *  锁不信不存在竞争，并且都是由同一个线程
 *  对象头markword 中偏向锁 是否存的是当前线程的id（先判断 锁类型 是不是偏向锁01  CAS比较替换 如果不同 阻塞）
 *
 *  轻量级锁 00
 *  先判断是不是偏向锁状态01  设置线程id 成功改为00状态，不成功先自旋，没成功，变成一个重量级锁10状态线程阻塞
 *
 *  重量级锁（锁膨胀，监视器）
 *
 *
 *
 *
 *
 *  -----------------------------
 *  Lock（I）
 *      常用的实现类
 *                  ReentrantLock  重入锁（当前线程可以重新，使用锁，并记录次数）
 *                  RWLock 读写锁（排它锁，共享锁在同一时间可以有多个线程获得锁， 分为读锁，写锁）
 *
 *  lock 和synchonized 的区别
 *   更灵活
 *   sychonized 是非公平锁，lock公平锁，费公平锁
 *
 *
 *   CAS (乐观锁)
 *
 *   AQS （AbstractQueuedSynchronizer） FIFO 队列
 *
 *    独占锁
 *    共享锁
 *
 *
 *   Condition
 *
 *
 *
 *
 *   CountDownLatch （递减）
 *          countdown/await
 *
 *   Semaphore （信号灯）  限流  许可
 *
 *
 *   Aomic
 *      12个
 *      基本类型/数组类型/引用类型/属性
 *
 *       AtomicBoolean
 *      AtomicInteger
 *      AtomicLong
 *
 *      AtomicIntegerArray
 *      AtomicLongArray
 *
 *      AtomicMarkableReference
 *      AtomicReference
 *      AtomicReferenceArray
 *      AtomicReferenceFieldUpdater
 *      AtomicStampedReference
 *      DoubleAccumulator
 *      DoubleAdder
 *      LongAccumulator
 *      LongAdder
 *      Striped64
 *
 *
 *      AtomicIntegerFieldUpdater
 *      AtomicLongFieldUpdater
 *
 *
 *   总结：
 *    JVM  synchronized  wait/notify             jdk Lock,countDownLatch，FutureTask,...
 *      cxq/waitSet/entryList                      AQS 实现（aqs 队列， condition队列）
 *
 *
 *  线程池
 *          druid 做数据库连接池
 *          线程-》线程池
 *
 *                  避免线程重复创建、限流
 *          Executors 工厂 创建线程池（ 越少让用户定义一些操作，系统越稳定）
 *                  newFixedThreadPool（创建一个固定的线程池）
 *                  newSingleThreadExecutor（创建只有一个线程的线程池）
 *                  newCachedThreadPool、 （不限制最大线程数）
 *                  newScheduledThreadPool （定时器， 延时执行的线程池）
 *
 *
 *     * newCachedThreadPool 可缓存的线程池
 *  *  * newCachedThreadPool的方法中是返回一个ThreadPoolExecutor实例，从源码中可以看出该线程池的特点：
 *  *  * 1、该线程池的核心线程数量是0，线程的数量最高可以达到Integer 类型最大值；
 *  *  * 2、创建ThreadPoolExecutor实例时传过去的参数是一个SynchronousQueue实例，说明在创建任务时，若存在空闲线程就复用它，没有的话再新建线程。
 *  *  * 3、线程处于闲置状态超过60s的话，就会被销毁。
 *  *
 *  *  newFixedThreadPool  定长线程池
 *  *   * 1、线程池的最大线程数等于核心线程数，并且线程池的线程不会因为闲置超时被销毁。
 *  *  * 2、使用的列队是LinkedBlockingQueue，表示如果当前线程数小于核心线程数，那么即使有空闲线程也不会复用线程去执行任务，
 *  *  * 而是创建新的线程去执行任务。如果当前执行任务数量大于核心线程数，此时再提交任务就在队列中等待，直到有可用线程。
 *  *
 *  *  SingleThreadExecutor　单线程线程池
 *  *  从源码就可以看出，该线程池基本就是只有一个线程数的newFixedThreadPool，它只有一个线程在工作，所有任务按照指定顺序执行。
 *  *
 *  *  newScheduledThreadPool　支持定时的定长线程池
 *  *  * 1、该线程池可以设置核心线程数量，最大线程数与newCachedThreadPool一样，都是Integer.MAX_VALUE。
 *  *  * 2、该线程池采用的队列是DelayedWorkQueue，具有延迟和定时的作用。
 *
 *                  newWorkStealingPool
 *                  newSingleThreadScheduledExecutor
 *
 *
 *          public ThreadPoolExecutor(int corePoolSize,//核心线程数
 *                               int maximumPoolSize,  //最大线程数
 *                               long keepAliveTime, //超时时间，  超出核心线程数量以外的空余线程的存活时间
 *                               TimeUnit unit,  //存活时间单位
 *                               BlockingQueue<Runnable> workQueue, //阻塞队列
 *                               ThreadFactory threadFactory,  //
 *                               RejectedExecutionHandler handler) { //reject 操作，  超出最大线程数的，拒绝的操作
 *
 *
 *    拒接策略
 *      AbortPolicy 直接跑出异常
 *      CallerRunsPolicy 调用者所在线程执行任务
 *      DiscardOldestPolicy丢弃祖阻塞任务中最前的丢掉 执行该任务
 *      Discardpolicy  直接抛出
 *
 *
 *   配置策略
 *   CPU密集型，IO密集型，混合型
 *   任务的执行时间
 *
 *
 *   CPU密集型（尽量小的核心数）
 *   IO密集型（按照cpu的核心数的数倍去设置）
 *   任务执行时间（）
 *
 *
 *   队列的选择和队列的大小（太大导致内存溢出）
 *
 *
 *
 *   线程的监控
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
 *
 *
 *
 */
