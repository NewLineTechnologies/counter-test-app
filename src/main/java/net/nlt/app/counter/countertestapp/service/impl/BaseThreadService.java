package net.nlt.app.counter.countertestapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.nlt.app.counter.countertestapp.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;

import java.util.Random;

import static java.lang.Thread.sleep;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
abstract class BaseThreadService {

    private static final Random RND = new Random();

    @Autowired
    @Qualifier("maxThreadPoolSizeTaskExecutor")
    protected TaskExecutor taskExecutor;

    @Autowired
    protected CounterService counterService;

    @SneakyThrows
    void delay() {
        sleep(RND.nextInt(10) + 10);
    }

    synchronized void log(String message) {
        log.info(message);
    }
}
