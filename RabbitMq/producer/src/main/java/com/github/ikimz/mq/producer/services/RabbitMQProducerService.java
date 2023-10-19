package com.github.ikimz.mq.producer.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String EXCHANGE_NAME = "my_exchange";
    private static final String ROUTING_KEY = "my_route";

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}
