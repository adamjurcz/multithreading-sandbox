package org.put.lesson5;

/**
 * Lekcja o volatile i sposoby na przetestowanie
 */

public class LessonRunner {
    public static void main(String[] args) throws InterruptedException {
        LessonRunner lessonRunner = new LessonRunner();
        lessonRunner.runVolatileExample();
    }

    public void runVolatileExample() throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();
        volatileExample.start();
        Thread.sleep(1000);
        volatileExample.stopRunning();
    }
}
