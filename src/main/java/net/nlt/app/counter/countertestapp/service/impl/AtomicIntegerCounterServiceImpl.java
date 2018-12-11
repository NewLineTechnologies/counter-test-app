package net.nlt.app.counter.countertestapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.nlt.app.counter.countertestapp.domain.LimitOverFlowLog;
import net.nlt.app.counter.countertestapp.repository.LimitOverflowLogRepository;
import net.nlt.app.counter.countertestapp.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class AtomicIntegerCounterServiceImpl implements CounterService {

    private int counter = 50;
    private boolean limitReached = false;

    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private LimitOverflowLogRepository repo;

    @Override
    public void increment() {
        lock.lock();
        try {
            if (isLimitReached()) {
                return;
            }
            counter++;
            log.info("{} incr to: {}", currentThread().getName(), counter);
            if (counter >= 100) {
                limitReached = true;
                saveTimeStamp(counter);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void decrement() {
        lock.lock();
        try {
            if (isLimitReached()) {
                return;
            }
            counter--;
            log.info("{} decr to: {}", currentThread().getName(), counter);
            if (counter <= 0) {
                limitReached = true;
                saveTimeStamp(counter);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void set(int value) {
        lock.lock();
        try {
            counter = value;
            limitReached = value <= 0 || value >= 100;
            log.info("{} set to: {}", currentThread().getName(), value);

            if (limitReached) {
                saveTimeStamp(value);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isLimitReached() {
        return limitReached;
    }

    private void saveTimeStamp(int limit) {
        LimitOverFlowLog log = new LimitOverFlowLog();

        log.setReachedLimitValue(limit);
        log.setTimestamp(Instant.now());

        repo.save(log);
    }
}
