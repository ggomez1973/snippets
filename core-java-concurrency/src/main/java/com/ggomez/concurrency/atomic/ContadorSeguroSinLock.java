package com.ggomez.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorSeguroSinLock {
    private final AtomicInteger counter = new AtomicInteger(0);

    int getValue() {
        return counter.get();
    }

    void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
}
