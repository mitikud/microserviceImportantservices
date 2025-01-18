package com.kafka.order_service.KafkaServeice;

import com.kafka.base_domain.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
//    private  topic  =  "order_topic";

    private final KafkaTemplate<String, OrderEvent> template;

    public OrderProducer(KafkaTemplate<String, OrderEvent> template) {

        this.template = template;
    }

    public void sendMessage(OrderEvent event ){

        LOGGER.info(String.format("Order event => %s ", event.toString()));

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "order_topic")
                .build();
        template.send(message);
    }

    public void sendToKafka(final OrderEvent event) {
//        final ProducerRecord<String, String> record = createRecord(data);
        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "order_topic")
                .build();

        CompletableFuture<SendResult<String, OrderEvent>> future = template.send(message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                handleSuccess(event);
                LOGGER.info("Message sent successfully for event: {}", event);
            }
            else {
                handleFailure(event, message, ex);
                LOGGER.error("Failed to send message for event: {}. Exception: {}", event, ex.getMessage(), ex);
            }
        });
    }

    private void handleSuccess(OrderEvent event) {
        // Example: Log the success
        LOGGER.info("Message sent successfully: {}", event);


    }

    private void handleFailure(OrderEvent event, Message<OrderEvent> message, Throwable ex) {

        LOGGER.error("Failed to send message: {}. Exception: {}", event, ex.getMessage(), ex);

        // database.updateEventStatus(event.getId(), status);
    }
}
