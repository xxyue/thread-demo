package com.example.thread.demo.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:  读写锁
 * 排它锁
 * 共享锁在同一时间可以有多个线程获得锁
 * 分为 读锁，写锁（在读多写少 的时候 使用，提升性能）
 *
 * @ClassName: RWLockDemo
 * @Author: yuexx
 * @Date: 2019/3/29 14:19
 * @Version: 1.0
 */
public class RWLockDemo {

    static Map<String, Object> cacheMap = new HashMap();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();//可重入读写锁
    static Lock readLock = reentrantReadWriteLock.readLock();//读锁
    static Lock writeLock = reentrantReadWriteLock.writeLock();//写锁

    /**
     *
     * @param key
     * @return
     */
    public static final Object get(String key){
        readLock.lock();//读锁
        try {
            return cacheMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static final Object set(String key , Object value){
        writeLock.lock();//写锁
        try {
            return  cacheMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

}
