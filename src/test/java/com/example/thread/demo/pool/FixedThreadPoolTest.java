package com.example.thread.demo.pool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: FixedThreadPoolTest
 * @Author: yuexx
 * @Date: 2019/3/1 15:59
 * @Version: 1.0
 */
public class FixedThreadPoolTest {

    FixedThreadPool fixedThreadPoolTest = new FixedThreadPool();

    @Test
    public void newFixedThreadPool() {
        fixedThreadPoolTest.newFixedThreadPool();
    }
}