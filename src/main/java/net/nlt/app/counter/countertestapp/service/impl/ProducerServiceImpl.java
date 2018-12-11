package net.nlt.app.counter.countertestapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nlt.app.counter.countertestapp.service.ProducerService;
import org.springframework.stereotype.Service;

import static java.lang.Thread.currentThread;

@Slf4j
@Service
@AllArgsConstructor
public class ProducerServiceImpl extends BaseThreadService implements ProducerService {

    @Override
    public void increaseProducersAmount(int delta) {
        for (int i = 0; i < delta; i++) {
            String name = "producer_" + i;
            taskExecutor.execute(() -> {
                currentThread().setName(name);
                while (true) {
                    delay();
                    counterService.increment();
                }
            });
        }
    }
}
