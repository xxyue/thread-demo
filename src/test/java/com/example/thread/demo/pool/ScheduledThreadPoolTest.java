package com.example.thread.demo.pool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: ScheduledThreadPoolTest
 * @Author: yuexx
 * @Date: 2019/3/1 16:22
 * @Version: 1.0
 */
public class ScheduledThreadPoolTest {

    ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool();
    @Test
    public void newScheduledThreadPool() {
        scheduledThreadPool.newScheduledThreadPool();
    }
}