package com.github.iquee.spring.rabbitmq.listener;

import com.github.iquee.spring.rabbitmq.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RabbitQueueListener {

    @RabbitListener(queues = Constants.QUEUE_NAME_TO_DEFAULT_EXCHANGE)
    public void defaultListen(String msg) {
        System.out.println("Message from default exchange ("+LocalDateTime.now()+"): " + msg);
    }

    @RabbitListener(queues = Constants.QUEUE_NAME_TO_EXCHANGE_1)
    public void listenSpecificExchange(String msg){
        System.out.println("Message from specific exchange ("+LocalDateTime.now()+"):  " + msg);
    }

}
