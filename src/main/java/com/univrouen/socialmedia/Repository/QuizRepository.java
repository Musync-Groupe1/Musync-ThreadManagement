package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
