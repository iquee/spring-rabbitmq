package com.github.iquee.spring.rabbitmq.producers;

import com.github.iquee.spring.rabbitmq.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DirectDefaultExchangeProducer implements CommandLineRunner {

    @Override
    public void run(String ...args) throws Exception {
        ConnectionFactory connectionFactory = new CachingConnectionFactory();
        AmqpTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend(Constants.QUEUE_NAME_TO_DEFAULT_EXCHANGE, "Using Plain Java to send message at " + LocalDateTime.now());
    }

    @Bean
    public ApplicationRunner runner(AmqpTemplate template) {
        return args -> template.convertAndSend(Constants.QUEUE_NAME_TO_DEFAULT_EXCHANGE, "Using Spring Boot Auto Configuration and an Async POJO Listener to send message at " + LocalDateTime.now());
    }
}
