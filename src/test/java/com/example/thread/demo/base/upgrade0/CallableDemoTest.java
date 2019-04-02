package com.example.thread.demo.base.upgrade0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: ${description}
 * @ClassName: CallableDemoTest
 * @Author: yuexx
 * @Date: 2019/3/21 18:54
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class CallableDemoTest {


    @Test
    public void call() {
        System.out.println("主线程名称 ： " + Thread.currentThread().getName());
        CallableDemo callableDeme0 = new CallableDemo(1000L);
        CallableDemo callableDeme1 = new CallableDemo(1000L);
        CallableDemo callableDeme2 = new CallableDemo(1000L);

        // 使用FutureTask来包装Callable对象
        FutureTask<String> future0 = new FutureTask<String>(callableDeme0);
        FutureTask<String> future2 = new FutureTask<String>(callableDeme1);
        FutureTask<String> future1 = new FutureTask<String>(callableDeme2);

        new Thread(future0).start();
        new Thread(future1).start();
        new Thread(future2).start();
        try {
            System.out.println(future0.get() + " 时间0 ： " + System.currentTimeMillis());
            System.out.println(future2.get() + " 时间2 ： " + System.currentTimeMillis());
            System.out.println(future1.get() + " 时间1 ： " + System.currentTimeMillis());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void call0() {
        System.out.println("主线程名称 ： " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDeme0 = new CallableDemo(10000L);
        CallableDemo callableDeme1 = new CallableDemo(20000L);
        CallableDemo callableDeme2 = new CallableDemo(30000L);
        Future<String> future0 = executorService.submit(callableDeme0);
        Future<String> future1 = executorService.submit(callableDeme0);
        Future<String> future2 = executorService.submit(callableDeme0);
        System.out.println(System.currentTimeMillis());
        try {
            System.out.println(future0.get() + " 时间0 ： " + System.currentTimeMillis());
            System.out.println(future2.get() + " 时间2 ： " + System.currentTimeMillis());
            System.out.println(future1.get() + " 时间1 ： " + System.currentTimeMillis());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void call1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDeme0 = new CallableDemo(10000L);
        CallableDemo callableDeme1 = new CallableDemo(20000L);
        CallableDemo callableDeme2 = new CallableDemo(30000L);
        Future<String> future0 = executorService.submit(callableDeme0);
        Future<String> future1 = executorService.submit(callableDeme0);
        Future<String> future2 = executorService.submit(callableDeme0);
        System.out.println(System.currentTimeMillis());
        try {

            System.out.println(future1.get() + " 时间1 ： " + System.currentTimeMillis());
            System.out.println(future0.get() + " 时间0 ： " + System.currentTimeMillis());
            System.out.println(future2.get() + " 时间2 ： " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void call2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDeme0 = new CallableDemo(10000L);
        CallableDemo callableDeme1 = new CallableDemo(20000L);
        CallableDemo callableDeme2 = new CallableDemo(30000L);
        Future<String> future0 = executorService.submit(callableDeme0);
        Future<String> future1 = executorService.submit(callableDeme0);
        Future<String> future2 = executorService.submit(callableDeme0);
        System.out.println(System.currentTimeMillis());
        try {
            System.out.println(future2.get() + " 时间2 ： " + System.currentTimeMillis());
            System.out.println(future1.get() + " 时间1 ： " + System.currentTimeMillis());
            System.out.println(future0.get() + " 时间0 ： " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}