package com.intuit.validationservice.producer;

import com.intuit.validationservice.entity.context.ValidationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientUpdateProducer {

    private final RabbitTemplate rabbitTemplate;

    static final String topicExchangeName = "client-profile-validation";

    public void publishClient(ValidationContext validationContext) {
        rabbitTemplate.convertAndSend(topicExchangeName, "client-profile-validation-key.*", validationContext);
    }
}
