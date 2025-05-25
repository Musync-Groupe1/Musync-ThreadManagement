package com.univrouen.socialmedia.Dto.kafka.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ToString
public class UserProfileMessage {
    private UserMessage user;

    private Integer profileId;

    private PictureMessage profilePicture;

    private List<PictureMessage> pictures;

    private Boolean isPrivate;

    private Boolean isCertified;

    private String description;

    private Integer acceptedAgeGap;

    private Integer acceptedDistance;

    private String targetedGender;

    private String favoriteMusician;

    private String favoriteMusic;

    private String favoriteMusicalStyle;

}