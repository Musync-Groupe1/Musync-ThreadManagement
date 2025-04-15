package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
}
