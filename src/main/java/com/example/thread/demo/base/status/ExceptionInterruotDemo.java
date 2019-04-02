package com.example.thread.demo.base.status;

import java.util.concurrent.TimeUnit;

/**
 * @Description: ${description}
 * @ClassName: EXceptionInterruotDemo
 * @Author: yuexx
 * @Date: 2019/3/22 15:49
 * @Version: 1.0
 */
public class ExceptionInterruotDemo {

//    private static int i;
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    throw new NullPointerException();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    System.out.println("NullPointerException " + Thread.currentThread().isInterrupted());
                } catch (InterruptedException ie){
                    System.out.println("InterruptedException " + Thread.currentThread().isInterrupted()  );
                }
            }
        },"ExceptionInterruotDemo");
        thread.start();
//        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();//设置interrupt 标识为true; 终止线程
        System.out.println("*********** befor1 + " + thread.isInterrupted());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("********** after1 + " + thread.isInterrupted());

    }
}
