package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Integer> {
}
