package com.kafka.stok_service.service;

import com.kafka.base_domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "order_topic", groupId = "stock")
    public void consume(OrderEvent event) {
        LOGGER.info("Order event received in stock service: {}", event.getMessage());

        try {
            // Validate the event
            validateEvent(event);

            // Save the event data to the DB
            saveEventToDatabase(event);

            LOGGER.info("Order event processed successfully: {}", event);
        } catch (Exception ex) {
            LOGGER.error("Error processing order event: {}. Exception: {}", event, ex.getMessage(), ex);
            // Optionally send the message to a dead-letter queue
            handleFailure(event, ex);
        }
    }

    private void validateEvent(OrderEvent event) throws IllegalArgumentException {
        if (event == null ) {
            throw new IllegalArgumentException("Invalid OrderEvent: ID cannot be null");
        }
        // Add additional validation logic if necessary
    }

    private void saveEventToDatabase(OrderEvent event) {
        // Replace with actual database save logic
        LOGGER.debug("Saving event to the database: {}", event);
        // Example: orderRepository.save(event);
    }

    private void handleFailure(OrderEvent event, Exception ex) {
        LOGGER.error("Handling failure for event: {}", event);
        // Example: send the failed message to a DLQ
        // deadLetterQueueProducer.send(event, ex.getMessage());
    }
}
