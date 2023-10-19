package com.github.ikimz.mq.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RabbitMQConsumerService {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitListener(queues = "my_queue")
    public void receiveMessage(String message) {
        processMessage(message);
    }

    private void processMessage(String message) {
        // Add your message processing logic here

        logger.info("Process message: {}", message);

        int sleepTime = new Random().nextInt(3 - 1 + 1) + 1;
        int sleepTimeInMs = sleepTime * 10000;
        logger.info("Sleep for {} sec", sleepTimeInMs/1000);

        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
