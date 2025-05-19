package org.put.lesson7;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class LessonRunner {

    public static void main(String[] args) throws Exception {
        runExecutorService();
    }

    private static void runExecutorService() throws Exception {
        int fibonacciNumber = 12;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> futureFibonacciResult = executorService.submit(new FibonacciCallable(fibonacciNumber));

        try {
            long result = futureFibonacciResult.get(3, TimeUnit.SECONDS);
            log.info("Fibonacci result is {}", result);
        } catch (TimeoutException e) {
            log.error("Fibonacci timeout");
            futureFibonacciResult.cancel(true);
        }

        executorService.shutdown();
    }
}
