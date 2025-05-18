package org.put.lesson6;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

@Slf4j
public class LessonRunner {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        deadlockExample();
    }

    @SneakyThrows
    public static void deadlockExample() {
        LessonRunner lessonRunner = new LessonRunner();
        new Thread(lessonRunner::deadlockOperation1).start();
        new Thread(lessonRunner::deadlockOperation2).start();
    }

    private void deadlockOperation1() {
        lock1.lock();
        log.info("Acquired lock1, waiting for lock2 in first operation");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            log.error("DeadlockOperation1 exception ", e);
        }
        lock2.lock();
        log.info("Acquired lock2 in second operation");

        lock2.unlock();
        lock1.unlock();
    }

    private void deadlockOperation2() {
        lock2.lock();
        log.info("Acquired lock2, waiting for lock1 in second operation");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            log.error("DeadlockOperation2 exception ", e);
        }
        lock1.lock();
        log.info("Acquired lock1 in second operation");

        lock1.unlock();
        lock2.unlock();
    }
    
}
