package com.example.thread.demo.juc.semaphore;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SemaphoreDemoTest
 * @Author: yuexx
 * @Date: 2019/4/2 9:47
 * @Version: 1.0
 */
public class SemaphoreDemoTest {

    @Test
    public void test0() {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.test0();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}