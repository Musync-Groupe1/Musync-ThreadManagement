package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollOptionRepository extends JpaRepository<PollOption, Integer> {
}
