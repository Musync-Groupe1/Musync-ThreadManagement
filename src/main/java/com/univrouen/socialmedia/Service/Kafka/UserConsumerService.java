package com.univrouen.socialmedia.Service.Kafka;


import com.univrouen.socialmedia.Dto.kafka.user.UserProfileMessage;
import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Mapper.UserProfileMapper;
import com.univrouen.socialmedia.Service.User.UserService;
import com.univrouen.socialmedia.Utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserConsumerService {
    private final UserProfileMapper userProfileMapper;
    private final UserService userService;

    public UserConsumerService(UserProfileMapper userProfileMapper,
                               UserService userService
    ) {
        this.userProfileMapper = userProfileMapper;
        this.userService = userService;
    }

    @KafkaListener(topics = {"user.created", "user.updated"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consumeUserCreated(String message) {
        try {
            log.info("Received user profile message: {}", message);
            UserProfileMessage userProfileMessage = JsonUtils.fromJson(message, UserProfileMessage.class);
            System.out.println("UserProfileMessage: " + userProfileMessage.toString());

            // Utiliser la nouvelle méthode
            this.userService.saveUserFromKafka(userProfileMessage);

            log.info("User saved with ID: {}", userProfileMessage.getUser().getUserId());
        } catch (Exception e) {
            log.error("Error processing user profile message: {}", e.getMessage(), e);
        }
    }

    @KafkaListener(topics = "user.deleted", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeUserDeleted(String message) {
        try {
            log.info("Received user delete profile message: {}", message);

            this.userService.deleteUserById(message);
            log.info("User delete with ID: {}", message);
        } catch (Exception e) {
            log.error("Error processing user profile message: {}", e.getMessage(), e);
        }
    }

}
