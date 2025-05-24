package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Users")
public class User {
    @Id
    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthday;

    private String gender;


    @JsonBackReference
    @OneToOne()
    @JoinColumn(
            name = "user_id"
    )
    private Profile profile;

    @JsonBackReference
    @OneToMany(
            mappedBy = "user"
    )
    private List<Post> posts;

    @JsonBackReference
    @OneToMany(
            mappedBy="user"
    )

    private List<Comment> comments;
}