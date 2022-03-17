package com.baidu.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ExecutorApplication01 {

    public static void main(String[] args) {
      ExecutorService executorService =  Executors.newCachedThreadPool();
      ExecutorService executorService1 =  Executors.newSingleThreadExecutor();
      ExecutorService executorService2 =  Executors.newFixedThreadPool(10);
      long currentMillis = System.currentTimeMillis();
      log.info("当前时间::"+currentMillis);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(1000);
                       log.info("i:::"+ finalI);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
        }
        log.info("运行耗时::"+(System.currentTimeMillis()-currentMillis));
        executorService.isShutdown();
    }
}
