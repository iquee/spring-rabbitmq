package com.github.iquee.spring.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class SpringRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

	@Bean
	@Order(1)
	public Queue createQueue() {
		return new Queue(Constants.QUEUE_NAME_TO_DEFAULT_EXCHANGE);
	}

	@Bean
	@Order(2)
	public DirectExchange createExchange1() {
		return new DirectExchange(Constants.EXCHANGE_1, false, true);
	}

	@Bean
	@Order(3)
	public Queue createQueueToExchange1() {
		return new Queue(Constants.QUEUE_NAME_TO_EXCHANGE_1, false);
	}

	@Bean
	@Order(4)
	public Binding binding() {
		return BindingBuilder.bind(createQueueToExchange1())
				.to(createExchange1())
				.with(Constants.ROUTING_KEY1);
	}
}
