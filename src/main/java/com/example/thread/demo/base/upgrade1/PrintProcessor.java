package com.example.thread.demo.base.upgrade1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: ${description}
 * @ClassName: PrintProcessor
 * @Author: yuexx
 * @Date: 2019/3/22 11:39
 * @Version: 1.0
 */
public class PrintProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    private final IRequestProcessor nextProcessor;

    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println("print data:" + request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
