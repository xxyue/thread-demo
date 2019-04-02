package com.example.thread.demo.base.upgrade1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: RequestUtileTest
 * @Author: yuexx
 * @Date: 2019/3/22 12:06
 * @Version: 1.0
 */
public class RequestUtileTest {

    @Test
    public void doSave() {

        Request request = new Request();
        request.setName("测试线程链路");

        RequestUtile requestUtile = new RequestUtile();
        requestUtile.doSave(request);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}