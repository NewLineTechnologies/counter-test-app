package net.nlt.app.counter.countertestapp.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static java.lang.Integer.MAX_VALUE;

@Configuration
public class CoreConfig {

    @Bean("maxThreadPoolSizeTaskExecutor")
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(MAX_VALUE);
        taskExecutor.setMaxPoolSize(MAX_VALUE);
        return taskExecutor;
    }
}
