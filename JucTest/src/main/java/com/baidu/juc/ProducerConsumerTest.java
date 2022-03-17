package com.baidu.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


@Slf4j
public class ProducerConsumerTest {


    public static void main(String[] args) {
        final Queue<Integer> queue = new LinkedBlockingQueue<>();
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();

    }

    static class Producer extends Thread{

        private final static int MAX_QUEUE_SIZE = 3;
        private final Queue queue;

        public Producer (Queue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue){
                    //队列已满 等待唤醒
                    if(queue.size()>=MAX_QUEUE_SIZE){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        queue.add(i);
                        System.out.println("生产中******"+i+":::"+Thread.currentThread().getName());
                        queue.notify();
                    }
                }
            }
        }
    }

    static class Consumer extends Thread{

        private final Queue queue;

        public Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            super.run();
            while(true){
                synchronized (queue){
                    while (queue.size() == 0){
                        try {
                            log.info("队列为空 等待::"+Thread.currentThread().getName());
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int numer = (int) queue.poll();
                    log.info("消费消息:::"+numer);
                    queue.notify();
                }
            }

        }
    }
}
