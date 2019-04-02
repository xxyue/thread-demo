package com.example.thread.demo.base.safe;

import java.util.concurrent.TimeUnit;

/**
 * @Description: ${description}
 * @ClassName: IntAddDemo
 * @Author: yuexx
 * @Date: 2019/3/27 15:12
 * @Version: 1.0
 */
public class IntAddDemo {

    private static volatile int i = 0;

    public static synchronized void test(){
        new Thread(() -> {
            i++;
        }).start();
//        new Thread(() -> {
//            i++;
//        }).start();


    }

    /**
     *  -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=dontinline,*IntAddDemo.test -XX:CompileCommand=compileonly,*IntAddDemo.test -XX:+PrintAssembly
     * @param args
     */
    public static void main(String[] args){
        for (int j = 0; j < 10000; j++) {
            new Thread(IntAddDemo::test).start();
        }


//        test();
//        i++;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
