package com.github.iquee.spring.rabbitmq.producers;

import com.github.iquee.spring.rabbitmq.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectSpecificExchangeProducer implements CommandLineRunner {

    @Autowired
    AmqpTemplate template;

    @Override
    public void run(String ... args) throws Exception {
        template.convertAndSend(Constants.EXCHANGE_1, Constants.ROUTING_KEY1, "Using a specific Exchange and Routing Key to send message");
    }
}
