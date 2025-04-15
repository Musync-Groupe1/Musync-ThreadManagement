package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
