package com.univrouen.socialmedia.Dto.kafka.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserMessage {
    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthdate;

    private String gender;
}