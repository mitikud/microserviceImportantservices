package com.kafka.email_service.service;

import com.kafka.base_domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "order_topic", groupId = "email")
    public void consume(OrderEvent event) {
        LOGGER.info("Order event processed successfully: {}", event);
    }
}
