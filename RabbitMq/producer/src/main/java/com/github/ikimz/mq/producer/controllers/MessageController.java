package com.github.ikimz.mq.producer.controllers;

import com.github.ikimz.mq.producer.services.RabbitMQProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    RabbitMQProducerService rabbitMQProducerService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/pushMsg")
    public ResponseEntity<Object> pushMsg() {

        String randomUUID = String.valueOf(UUID.randomUUID());
        rabbitMQProducerService.sendMessage("{\"message\": \"" + randomUUID +"\"}");
        logger.info("Push UUID: {} to queue", randomUUID);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
