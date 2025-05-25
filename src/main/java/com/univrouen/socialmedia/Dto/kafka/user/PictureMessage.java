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
public class PictureMessage {
    private Integer pictureId;

    private String link;

    private String name;

    private LocalDate postedDate;
}