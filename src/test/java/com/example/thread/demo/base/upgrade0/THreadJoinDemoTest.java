package com.example.thread.demo.base.upgrade0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Description: ${description}
 * @ClassName: JoinDemoTest
 * @Author: yuexx
 * @Date: 2019/3/26 20:25
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class THreadJoinDemoTest {


    /**
     *  三个线程 没有添加任何限制， 顺序是随机的
     */
    @Test
    public void threeNoJoin() {
        for (int i = 0; i < 100; i++) {
            THreadJoinDemo THreadJoinDemo = new THreadJoinDemo();
            THreadJoinDemo.threeNoJoin();
            System.out.println("***************");
        }
    }


    /**
     * 所有线程数据都是 t1 -> t2 -> t3
     * @throws Exception
     */
    @Test
    public void threeJoin0() throws Exception{
        for (int i = 0; i < 100; i++) {
            THreadJoinDemo THreadJoinDemo = new THreadJoinDemo();
            THreadJoinDemo.threeJoin0();
            System.out.println("***************");
        }

    }

    @Test
    public void threeJoin1() throws Exception{
        THreadJoinDemo THreadJoinDemo = new THreadJoinDemo();
        THreadJoinDemo.threeJoin1();
    }
}