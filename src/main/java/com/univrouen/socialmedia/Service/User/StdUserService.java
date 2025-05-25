package com.univrouen.socialmedia.Service.User;

import com.univrouen.socialmedia.Dto.kafka.user.UserProfileMessage;
import com.univrouen.socialmedia.Entity.Picture;
import com.univrouen.socialmedia.Entity.Profile;
import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StdUserService implements UserService {
    private final UserRepository userRepository;

    public StdUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(String id) {
        return this.userRepository.existsUserByUserId(id);
    }

    public Map<String, User> getUsersByIds(List<String> userIds) {
        List<User> users = userRepository.findAllByUserIdIn(userIds);
        return users.stream()
                .collect(Collectors.toMap(
                        User::getUserId,
                        user -> user
                ));
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = this.userRepository.findUserByUserId(authentication.getName());
        if (user.isEmpty())
            throw new IllegalArgumentException("User not found");
        return user.get();
    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.findUserByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public void deleteUserById(String id) {
        User user = this.userRepository.findUserByUserId(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        this.userRepository.delete(user);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void saveUserFromKafka(UserProfileMessage userProfileMessage) {
        // Extraire les données de l'utilisateur
        User user = User.builder()
                .userId(userProfileMessage.getUser().getUserId())
                .firstName(userProfileMessage.getUser().getFirstName())
                .lastName(userProfileMessage.getUser().getLastName())
                .email(userProfileMessage.getUser().getEmail())
                .birthday(userProfileMessage.getUser().getBirthdate()) // Pas besoin de parse
                .gender(userProfileMessage.getUser().getGender())
                .build();

        // Créer l'image de profil si présente
        Picture profilePicture = null;
        if (userProfileMessage.getProfilePicture() != null) {
            profilePicture = Picture.builder()
                    .pictureId(userProfileMessage.getProfilePicture().getPictureId())
                    .link(userProfileMessage.getProfilePicture().getLink())
                    .name(userProfileMessage.getProfilePicture().getName())
                    .postedDate(userProfileMessage.getProfilePicture().getPostedDate()) // Pas besoin de parse
                    .build();
        }

        // Créer la liste des images si présente
        List<Picture> pictures = null;
        if (userProfileMessage.getPictures() != null && !userProfileMessage.getPictures().isEmpty()) {
            pictures = userProfileMessage.getPictures().stream()
                    .map(pic -> Picture.builder()
                            .pictureId(pic.getPictureId())
                            .link(pic.getLink())
                            .name(pic.getName())
                            .postedDate(pic.getPostedDate()) // Pas besoin de parse
                            .build())
                    .collect(Collectors.toList());
        }

        // Créer le profil
        Profile profile = Profile.builder()
                .profileId(userProfileMessage.getProfileId())
                .userId(String.valueOf(userProfileMessage.getUser().getUserId()))
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

        // Établir les relations
        user.setProfile(profile);
        profile.setUser(user);

        if (profilePicture != null) {
            profile.setProfilePicture(profilePicture);
            profilePicture.setProfilePicture(profile);
        }

        if (pictures != null) {
            profile.setPictures(pictures);
            pictures.forEach(pic -> pic.setProfilePictures(profile));
        }

        // Sauvegarder l'utilisateur (et en cascade le profil et les images)
        userRepository.save(user);
    }
}
