package org.put.lesson1;

/**
 * Lekcja o sposobach implementacji wątków
 */

public class LessonRunner {
    public static void main(String[] args) {
        var lessonRunner = new LessonRunner();
        //lessonRunner.runThreadWithThreadSubclass();
        //lessonRunner.runThreadWithRunnableExplicitImplementation();
        //lessonRunner.runThreadWithRunnableAnonymousImplementation();

    }

    void runThreadWithThreadSubclass() {
        MyThread myThread = new MyThread("MyThread");
        myThread.start();
        System.out.println("First method - Thread is running - " + Thread.currentThread().getName());
    }

    void runThreadWithRunnableExplicitImplementation() {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "MyRunnableExplicitImplement");
        thread.start();
        System.out.println("Second method - Thread is running - " + Thread.currentThread());
    }

    void runThreadWithRunnableAnonymousImplementation() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in anonymous runnable implementation");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Third method - Thread is running - " + Thread.currentThread());
    }
}
