package com.example.thread.demo.queue.blocking;

/**
 * 1、没有实现的阻塞接口的LinkedList： 实现了java.util.Queue接口和java.util.AbstractQueue接口
 *   内置的不阻塞队列： PriorityQueue 和 ConcurrentLinkedQueue
 * PriorityQueue 和 ConcurrentLinkedQueue 类在 Collection Framework 中加入两个具体集合实现。
 *
 * PriorityQueue 类实质上维护了一个有序列表。加入到 Queue 中的元素根据它们的天然排序（通过其
 * java.util.Comparable 实现）或者根据传递给构造函数的 java.util.Comparator 实现来定位。
 *
 * ConcurrentLinkedQueue 是基于链接节点的、线程安全的队列。并发访问不需要同步。因为它在队列的尾部
 * 添加元素并从头部删除它们，所以只要不需要知道队列的大 小， ConcurrentLinkedQueue 对公
 * 共集合的共享访问就可以工作得很好。收集关于队列大小的信息会很慢，需要遍历队列
 */
