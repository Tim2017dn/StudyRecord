package com.dn.leanredis.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncDemo {
    private static final Logger log = LoggerFactory.getLogger(AsyncDemo.class);

    @Async
    public void test1() throws InterruptedException {
//        Thread.currentThread().wait(10);
        int t=0;
        for(int i=1;i<1000;i++){
            t+=i;
        }
        log.info("test1");
    }

    @Async
    public void test2(String s){
        log.info("parameter = "+s);
    }

    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, parementer={}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        }
        return future;

    }
}
