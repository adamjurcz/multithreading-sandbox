package org.put.lesson2;

import java.util.stream.IntStream;

public class LessonRunner {

    public static void main(String[] args) {

    }

    void threadExample1() {
        int threadsNumber = 10;
        Thread[] threads = new Thread[threadsNumber];
        IntStream.range(0, threadsNumber).forEach(number -> {
            threads[number] = new Thread("Nr." + number) {
                @Override
                public void run() {
                    if (number == 5) {
                        try {
                            Thread.sleep(3 * 1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Welcome in Thread: " + getName());
                }
            };
        });

        IntStream.range(0, threadsNumber).forEach(number -> {
            threads[number].start();
        });
    }

    void threadExample2() {
        MyRunnableStop runnable = new MyRunnableStop();
        Thread thread = new Thread(runnable, "MyRunnableStop");
        thread.start();
        try {
            Thread.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        runnable.stopThread();
        System.out.println("Finished main thread");
    }
}
