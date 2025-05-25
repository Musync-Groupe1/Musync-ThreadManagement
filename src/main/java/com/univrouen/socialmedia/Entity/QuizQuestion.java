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
@Table(name="quiz_question")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "quiz_id"
    )
    private Quiz quiz;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "quizQuestion"
    )
    private List<QuizQuestionOption> quizQuestionOptions;
}
