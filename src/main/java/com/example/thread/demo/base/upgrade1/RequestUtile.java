package com.example.thread.demo.base.upgrade1;


/**
 * @Description: ${description}
 * @ClassName: IRequestProcessorTest
 * @Author: yuexx
 * @Date: 2019/3/22 11:47
 * @Version: 1.0
 */
public class RequestUtile {

    private PrintProcessor printProcessor;

    public RequestUtile() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public void doSave(Request request) {
        printProcessor.processorRequest(request);
    }




}