package net.nlt.app.counter.countertestapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nlt.app.counter.countertestapp.service.ConsumerService;
import net.nlt.app.counter.countertestapp.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Thread.currentThread;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerServiceImpl extends BaseThreadService implements ConsumerService {

    @Autowired
    private CounterService counterService;

    @Override
    public void increaseConsumersAmount(int delta) {
        for (int i = 0; i < delta; i++) {
            String name = "consumer_" + i;
            taskExecutor.execute(() -> {
                currentThread().setName(name);
                while (true) {
                    delay();
                    counterService.decrement();
                }
            });
        }
    }
}
