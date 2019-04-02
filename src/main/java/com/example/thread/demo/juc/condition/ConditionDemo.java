package com.example.thread.demo.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description: ${description}
 * @ClassName: Condition
 * @Author: yuexx
 * @Date: 2019/3/29 16:58
 * @Version: 1.0
 */
public class ConditionDemo {
    private Lock lock;
    private Condition condition;

    public ConditionDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


}
