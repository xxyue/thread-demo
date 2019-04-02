package com.example.thread.demo.pool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: CachedThreadPoolTest
 * @Author: yuexx
 * @Date: 2019/3/1 14:33
 * @Version: 1.0
 */
public class CachedThreadPoolTest {
    CachedThreadPool cachedThreadPool= new CachedThreadPool();

    @Test
    public void newCachedThreadPool() {
        cachedThreadPool.newCachedThreadPool();
    }
}