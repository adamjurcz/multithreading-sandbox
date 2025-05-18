package org.put.lesson1;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread is running - " + Thread.currentThread().getName());
    }
}
