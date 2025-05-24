package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @OneToOne(
            mappedBy = "quiz"
    )
    private Post post;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "quiz"
    )
    private List<QuizQuestion> questions;



}
