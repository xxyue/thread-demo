package com.example.thread.demo.base.status;

import java.util.concurrent.TimeUnit;

/**
 * @Description: ${description}
 * @ClassName: FlagInterroutDemo
 * @Author: yuexx
 * @Date: 2019/3/22 16:13
 * @Version: 1.0
 */
public class FlagInterroutDemo {
    volatile boolean stop = false;

    public void threadPrint(String str){
        new Thread(()->{
            while (!stop){

                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"FlagInterroutDemo").start();
    }
    
    public static void main(String[] args){
        FlagInterroutDemo demo = new FlagInterroutDemo();
        demo.threadPrint("111");
        demo.threadPrint("2222");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.stop= true;

    }
}
