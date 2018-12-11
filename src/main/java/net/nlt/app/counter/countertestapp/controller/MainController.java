package net.nlt.app.counter.countertestapp.controller;

import lombok.extern.slf4j.Slf4j;
import net.nlt.app.counter.countertestapp.service.ConsumerService;
import net.nlt.app.counter.countertestapp.service.CounterService;
import net.nlt.app.counter.countertestapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private CounterService counterService;

    @GetMapping(path = "/threads")
    public ResponseEntity threads(@RequestParam int prods, @RequestParam int cons) {
        producerService.increaseProducersAmount(prods);
        consumerService.increaseConsumersAmount(cons);
        return ResponseEntity.created(URI.create("/threads")).build();
    }

    @GetMapping(path = "/counter")
    public void setCounter(@RequestParam int value) {
        counterService.set(value);
    }
}
