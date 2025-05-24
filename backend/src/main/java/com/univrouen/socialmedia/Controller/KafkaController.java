package com.univrouen.socialmedia.Controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private static final String TOPIC = "topic-test";
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
    }

}
