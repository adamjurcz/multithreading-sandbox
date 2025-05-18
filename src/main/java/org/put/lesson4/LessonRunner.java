package org.put.lesson4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LessonRunner {
    public static void main(String[] args) {
        var lessonRunner = new LessonRunner();
        lessonRunner.runProducersConsumers();
    }

    public void runProducersConsumers()  {
        var buffer = new ProductBuffer(10);
        var producer = new Producer(buffer);
        var consumer = new Consumer(buffer);

        var producerThread = new Thread(producer);
        var consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex ) {
            log.error("Interrupted exception happened ", ex);
            Thread.currentThread().interrupt();
        }
    }
}
