package com.github.iquee.spring.rabbitmq.producers;

import com.github.iquee.spring.rabbitmq.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectSpecificExchangeProducer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    }

    @Bean
    public ApplicationRunner toSpecificExchange(AmqpTemplate template) {
        return args -> template.convertAndSend(Constants.EXCHANGE_1, Constants.QUEUE_NAME_TO_EXCHANGE_1, "routing key message");
    }
}
