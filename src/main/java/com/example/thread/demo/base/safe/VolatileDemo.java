package com.example.thread.demo.base.safe;

/**
 * @Description: volatile 的内存屏障使得可见性
 * @ClassName: VolatileDemo
 * @Author: yuexx
 * @Date: 2019/3/25 11:15
 * @Version: 1.0
 */
public class VolatileDemo {

    private static volatile VolatileDemo instance = null;

    public static VolatileDemo getInstance(){
        if (instance == null){
            instance = new VolatileDemo();
        }
        return instance;
    }

    /**
     *  让其输出 汇编指令
     *  -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*VolatileDemo.getInstance VolatileDemo
     *   jre /bin/server 下添加 hsdis-amd64.dll
     *  -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=dontinline,*VolatileDemo.getInstance -XX:CompileCommand=compileonly,*VolatileDemo.getInstance -XX:+PrintAssembly
     *  lock
     */
    public static void main(String[] args){
        VolatileDemo.getInstance();
    }
}
