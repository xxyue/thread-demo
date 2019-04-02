package com.example.thread.demo.queue.no_bloking;

/**
 *实现阻塞接口:
 * java.util.concurrent 中加入了 BlockingQueue 接口和五个阻塞队列类。它实质上就是一种带有一点扭曲的
 * FIFO 数据结构。不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用。
 *
 * 五个队列所提供的各有不同：
 * * ArrayBlockingQueue ：一个由数组支持的有界队列。
 * * LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
 * * PriorityBlockingQueue ：一个由优先级堆支持的无界优先级队列。
 * * DelayQueue ：一个由优先级堆支持的、基于时间的调度队列。
 * * SynchronousQueue ：一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。
 *
 * 下表显示了jdk1.5中的阻塞队列的操作：
 * add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * offer 添加一个元素并返回true 如果队列已满，则返回false
 * poll 移除并返问队列头部的元素 如果队列为空，则返回null
 * peek 返回队列头部的元素 如果队列为空，则返回null
 * put 添加一个元素 如果队列满，则阻塞
 * take 移除并返回队列头部的元素 如果队列为空，则阻塞
 * remove、element、offer 、poll、peek 其实是属于Queue接口。
 *
 * 阻塞队列的操作可以根据它们的响应方式分为以下三类：aad、removee和element操作在你试图为一个已满的队
 * 列增加元素或从空队列取得元素时 抛出异常。当然，在多线程程序中，队列在任何时间都可能变成满的或空的，所
 * 以你可能想使用offer、poll、peek方法。这些方法在无法完成任务时 只是给出一个出错示而不会抛出异常。
 *
 *最后，我们有阻塞操作put和take。put方法在队列满时阻塞，take方法在队列空时阻
 *
 *
 * LinkedBlockingQueue的容量是没有上限的（说的不准确，在不指定时容量为Integer.MAX_VALUE，不要然
 * 的话在put时怎么会受阻呢），但是也可以选择指定其最大容量，它是基于链表的队列，此队列按 FIFO（先进先
 * 出）排序元素。
 *
 * ArrayBlockingQueue在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，等待
 * 时间最长的线程会优先得到处理（其实就是通过将ReentrantLock设置为true来 达到这种公平性的：即等待时间
 * 最长的线程会先操作）。通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。它是基于
 * 数组的阻塞循环队 列，此队列按 FIFO（先进先出）原则对元素进行排序。
 *
 * PriorityBlockingQueue是一个带优先级的 队列，而不是先进先出队列。元素按优先级顺序被移除，该队列也
 * 没有上限（看了一下源码，PriorityBlockingQueue是对 PriorityQueue的再次包装，是基于堆数据结构的，而
 * PriorityQueue是没有容量限制的，与ArrayList一样，所以在优先阻塞 队列上put时是不会受阻的。虽然此队列逻
 * 辑上是无界的，但是由于资源被耗尽，所以试图执行添加操作可能会导致 OutOfMemoryError），但是如果队列
 * 为空，那么取元素的操作take就会阻塞，所以它的检索操作take是受阻的。另外，往入该队列中的元 素要具有比
 * 较能力。
 *
 * DelayQueue（基于PriorityQueue来实现的）是一个存放Delayed 元素的无界阻塞队列，只有在延迟期满时才
 * 能从中提取元素。该队列的头部是延迟期满后保存时间最长的 Delayed 元素。如果延迟都还没有期满，则队列没
 * 有头部，并且poll将返回null。当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于或等于零
 * 的值时，则出现期满，poll就以移除这个元素了。此队列不允许使用 null 元素。
 *
 */
