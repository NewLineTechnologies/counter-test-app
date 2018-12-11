package net.nlt.app.counter.countertestapp.service;

public interface CounterService {

    void increment();

    void decrement();

    void set(int value);

    boolean isLimitReached();
}
