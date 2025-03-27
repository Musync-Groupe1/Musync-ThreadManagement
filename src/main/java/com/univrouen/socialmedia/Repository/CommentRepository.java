package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
