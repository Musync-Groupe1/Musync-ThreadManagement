package com.univrouen.socialmedia.Controller;

import com.univrouen.socialmedia.Dto.kafka.user.UserProfileMessage;
import com.univrouen.socialmedia.Service.Kafka.UserProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final UserProducerService producerService;

    public KafkaController(UserProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<String> createUser(@RequestBody UserProfileMessage message) {
        producerService.sendUserCreatedMessage(message);
        return ResponseEntity.ok("Message envoyé au topic user.created");
    }

    @PostMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody UserProfileMessage message) {
        producerService.sendUserUpdatedMessage(message);
        return ResponseEntity.ok("Message envoyé au topic user.updated");
    }

    @PostMapping("/user/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        producerService.sendUserDeletedMessage(userId);
        return ResponseEntity.ok("Message envoyé au topic user.deleted");
    }
}
  /*  private static final String TOPIC = "topic-test";
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics=TOPIC, groupId = "my-group")
    public void test(String message){
        System.out.println(message);
    }

    @PostMapping("/test")
    public void testKafka(){
        kafkaTemplate.send(TOPIC, "test");
    }*/

