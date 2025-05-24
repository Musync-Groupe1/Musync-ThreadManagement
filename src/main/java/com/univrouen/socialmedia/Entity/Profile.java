package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;

    @JsonManagedReference
    @OneToOne(
            mappedBy = "profile"
    )
    private User user;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(
            name = "profile_picture_id"
    )
    private Picture profilePicture;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "profilePictures"
    )
    private List<Picture> pictures;

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