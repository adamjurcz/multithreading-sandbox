package org.put.lesson7;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class FibonacciCallable implements Callable<Long> {
    private final int n;

    @Override
    public Long call() {
        return calculate(n);
    }

    private long calculate(int n) {
        if (Thread.currentThread().isInterrupted()) {
            return 0;
        }
        if (n <= 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}
