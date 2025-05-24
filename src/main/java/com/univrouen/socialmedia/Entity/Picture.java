package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pictureId;

    private String link;

    private String name;

    private LocalDate postedDate;

    @JsonBackReference
    @OneToOne(
            mappedBy = "profilePicture"
    )
    private Profile profilePicture;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "profile_id"
    )
    private Profile profilePictures;

}