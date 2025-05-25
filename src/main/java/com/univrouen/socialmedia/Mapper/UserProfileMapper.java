package com.univrouen.socialmedia.Mapper;


import com.univrouen.socialmedia.Dto.kafka.user.UserProfileMessage;
import com.univrouen.socialmedia.Entity.Picture;
import com.univrouen.socialmedia.Entity.Profile;
import com.univrouen.socialmedia.Entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserProfileMapper {

    private final PictureMapper pictureMapper;

    public UserProfileMapper(PictureMapper pictureMapper) {
        this.pictureMapper = pictureMapper;
    }

    public User toUser(UserProfileMessage userProfileMessage) {
        return User.builder()
                .userId(String.valueOf(userProfileMessage.getUser().getUserId()))
                .firstName(userProfileMessage.getUser().getFirstName())
                .lastName(userProfileMessage.getUser().getLastName())
                .email(userProfileMessage.getUser().getEmail())
                .birthday(userProfileMessage.getUser().getBirthdate())
                .gender(userProfileMessage.getUser().getGender())
                .profile(toProfile(userProfileMessage))
                .build();
    }

    private Profile toProfile(UserProfileMessage userProfileMessage) {
        Picture profilePicture = null;
        if (userProfileMessage.getProfilePicture() != null) {
            profilePicture = pictureMapper.toPicture(userProfileMessage.getProfilePicture());
        }

        return Profile.builder()
                .profileId(userProfileMessage.getProfileId())
                .profilePicture(profilePicture)
                .pictures(userProfileMessage.getPictures() != null
                        ? userProfileMessage.getPictures().stream()
                        .map(pictureMapper::toPicture)
                        .collect(Collectors.toList())
                        : null)
                .isPrivate(userProfileMessage.getIsPrivate())
                .isCertified(userProfileMessage.getIsCertified())
                .description(userProfileMessage.getDescription())
                .acceptedAgeGap(userProfileMessage.getAcceptedAgeGap())
                .acceptedDistance(userProfileMessage.getAcceptedDistance())
                .targetedGender(userProfileMessage.getTargetedGender())
                .favoriteMusician(userProfileMessage.getFavoriteMusician())
                .favoriteMusic(userProfileMessage.getFavoriteMusic())
                .favoriteMusicalStyle(userProfileMessage.getFavoriteMusicalStyle())
                .build();
    }
}