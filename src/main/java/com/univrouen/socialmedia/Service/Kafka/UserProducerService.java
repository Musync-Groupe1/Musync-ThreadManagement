package com.univrouen.socialmedia.Service.Kafka;

import com.univrouen.socialmedia.Dto.kafka.user.UserProfileMessage;
import com.univrouen.socialmedia.Utils.JsonUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedMessage(UserProfileMessage message) {
        kafkaTemplate.send("user.created", JsonUtils.toJson(message));
    }

    public void sendUserUpdatedMessage(UserProfileMessage message) {
        kafkaTemplate.send("user.updated", JsonUtils.toJson(message));
    }

    public void sendUserDeletedMessage(String userId) {
        kafkaTemplate.send("user.deleted", userId);
    }
}