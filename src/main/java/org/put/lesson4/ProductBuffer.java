package org.put.lesson4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ProductBuffer {
    private final List<String> products = new ArrayList<>();
    private final int maxSize;

    public synchronized void addProduct(String product) {
        while (products.size() == maxSize) {
            waitForSignal();
        }
        products.add(product);
        log.info("Added product {} in thread {}", product, Thread.currentThread().getName());
        notify();
    }

    public synchronized void consumeProduct() {
        while (products.isEmpty()) {
            waitForSignal();
        }
        var product = products.removeLast();
        log.info("Removed product {} in thread {}", product, Thread.currentThread().getName());
        notify();
    }

    private void waitForSignal() {
        try {
            wait();
        } catch (InterruptedException e) {
            log.error("Wait was interrupted in thread {}", Thread.currentThread().getName());
        }
    }
}
