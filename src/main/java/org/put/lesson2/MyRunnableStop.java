package org.put.lesson2;

public class MyRunnableStop implements Runnable {
    private boolean isStopped = false;

    public synchronized void stopThread() {
        isStopped = true;
    }

    private synchronized boolean shouldContinue() {
        return !isStopped;
    }

    @Override
    public void run() {
        int number = 0;

        while (shouldContinue()) {
            System.out.println("I should continue no." + number);
            try {
                Thread.sleep(2 * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            number++;
        }
    }
}
