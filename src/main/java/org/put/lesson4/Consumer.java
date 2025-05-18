package org.put.lesson4;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Consumer implements Runnable{
    private static final int PRODUCTS_NUMBER = 10;

    private final ProductBuffer buffer;

    @Override
    public void run() {
        IntStream.range(0, PRODUCTS_NUMBER).forEach(productNumber -> buffer.consumeProduct());
    }
}
