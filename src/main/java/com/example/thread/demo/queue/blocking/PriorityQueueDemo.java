package com.example.thread.demo.queue.blocking;

import java.util.*;

/**
 * @Description:
 * @ClassName: PriorityQueueDemo
 * @Author: yuexx
 * @Date: 2019/3/6 15:49
 * @Version: 1.0
 */
public class PriorityQueueDemo {
    PriorityQueue queue = new PriorityQueue();
    
    public static void main(String[] args){
        List<Map<String,String>> arr = new ArrayList<>();
        Map<String,String> map1= new HashMap<>();
        map1.put("11","21");
        map1.put("12","22");
        Map<String,String> map2= new HashMap<>();
        map2.put("33","44");
        arr.add(map1);
        arr.add(map2);
        
        System.out.println(arr);

    }
}
