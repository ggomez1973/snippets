package com.ggomez.concurrency.atomic;

public class ContadorSeguroConLock {
    private volatile int counter;

    int getValue() {
        return counter;
    }

    synchronized void increment() {
        counter++;
    }
}
