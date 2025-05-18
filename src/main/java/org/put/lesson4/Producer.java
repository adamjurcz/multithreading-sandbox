package org.put.lesson4;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Producer implements Runnable {
    private static final int PRODUCTS_NUMBER = 10;

    private final ProductBuffer buffer;

    @Override
    public void run() {
        IntStream.range(0, PRODUCTS_NUMBER).forEach(number -> buffer.addProduct(createProduct(number)));
    }

    private String createProduct(int number) {
        return String.format("PRODUCT_%s", number);
    }

}
