package com.example.thread.demo.pool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SingleThreadExecutorTest
 * @Author: yuexx
 * @Date: 2019/3/1 16:09
 * @Version: 1.0
 */
public class SingleThreadExecutorTest {

    SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();
    @Test
    public void newFixedThreadPool() {
        singleThreadExecutor.newSingleThreadExecutor();
    }
}