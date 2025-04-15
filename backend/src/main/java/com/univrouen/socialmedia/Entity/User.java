package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Users")
public class User {
    @Id
    private String user_id;

    private String first_name;

    private String last_name;

    private String email;

    private Date birthday;

    private String gender;

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