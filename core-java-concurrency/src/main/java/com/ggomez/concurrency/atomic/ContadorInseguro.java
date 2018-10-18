package com.ggomez.concurrency.atomic;

public class ContadorInseguro {
    private int counter;

    int getValue() {
        return counter;
    }

    void increment() {
        counter++;
    }
}
