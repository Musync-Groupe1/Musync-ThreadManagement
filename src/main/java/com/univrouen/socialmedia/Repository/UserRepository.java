package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
