package com.univrouen.socialmedia.Mapper;


import com.univrouen.socialmedia.Dto.kafka.user.PictureMessage;
import com.univrouen.socialmedia.Entity.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

    public Picture toPicture(PictureMessage pictureMessage) {
        if (pictureMessage == null) {
            return null;
        }

        return Picture.builder()
                .pictureId(pictureMessage.getPictureId())
                .link(pictureMessage.getLink())
                .name(pictureMessage.getName())
                .postedDate(pictureMessage.getPostedDate())
                .build();
    }
}