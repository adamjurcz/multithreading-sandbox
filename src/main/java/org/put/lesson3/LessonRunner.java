package org.put.lesson3;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 *
 */

@Slf4j
public class LessonRunner {
    private static final int THREADS_NUMBER = 5;
    private static final int INCREMENT_NUMBER = 1000;

    public static void main(String[] args) {
        nonSynchronizationExample();
    }

    public static void synchronizationExample() {

    }

    public static void nonSynchronizationExample() {
        IncrementNonSync incrementNonSync = new IncrementNonSync();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);

        List<Callable<Object>> updateTasks = IntStream.range(0, THREADS_NUMBER).mapToObj(i -> updateTask(incrementNonSync, INCREMENT_NUMBER)).toList();
        try {
            executorService.invokeAll(updateTasks);
            executorService.shutdown();
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("NonSynchronizationExample : Value is equal {}, should be {}", incrementNonSync.getNumber(), INCREMENT_NUMBER * THREADS_NUMBER);
    }

    private static Callable<Object> updateTask(IncrementNonSync incrementNonSync, int incrementationNumber) {
        return () -> {
            log.info("Thread {} started incrementing", Thread.currentThread().getName());
            IntStream.range(0, incrementationNumber).forEach(i -> incrementNonSync.increment());
            log.info("Thread {} finished incrementing", Thread.currentThread().getName());
            return null;
        };
    }

}
