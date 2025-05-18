package org.put.lesson5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileExample extends Thread {
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        log.info("Started running in volatile example");
        while (isRunning) {
            Thread.onSpinWait();
        }
        log.info("Finished running in volatile example instantly");
    }

    public void stopRunning() {
        isRunning = false;
    }
}
