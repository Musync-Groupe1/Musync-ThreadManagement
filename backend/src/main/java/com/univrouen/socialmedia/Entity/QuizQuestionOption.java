package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="quiz_question")
public class QuizQuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String option;

    private Boolean is_correct;

    private Integer count = 0;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "quiz_question_id"
    )
    private QuizQuestion quizQuestion;


}
