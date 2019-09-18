 Getting Started

### run
```docker run -d --hostname rabbitmq --name rabbitmq -p 15672:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management```

```mvn spring-boot:run```


One new exchange will be created
![Image of exchange](https://github.com/iquee/spring-rabbitmq/blob/master/src/main/resources/images/exchange.png?raw=true)

Two new queues will be created
![Image of queues](https://github.com/iquee/spring-rabbitmq/blob/master/src/main/resources/images/queues.png?raw=true)

