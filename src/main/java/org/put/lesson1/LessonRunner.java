package org.put.lesson1;

/**
 * Lekcja o sposobach implementacji wątków
 */

public class LessonRunner {
    public static void main(String[] args) throws InterruptedException {
        runThreadWithThreadSubclass();
        runThreadWithRunnableExplicitImplementation();
        runThreadWithRunnableAnonymousImplementation();
    }

    private static void runThreadWithThreadSubclass() throws InterruptedException {
        MyThread myThread = new MyThread("MyThread");
        myThread.start();
        System.out.println("First method - Thread is running - " + myThread.getName());
        myThread.join();
    }

    private static void runThreadWithRunnableExplicitImplementation() throws InterruptedException {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "MyRunnableExplicitImplement");
        thread.start();
        System.out.println("Second method - Thread is running - " + thread.getName());
        thread.join();
    }

    private static void runThreadWithRunnableAnonymousImplementation() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in anonymous runnable implementation");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Third method - Thread is running - " + thread.getName());
        thread.join();
    }
}
