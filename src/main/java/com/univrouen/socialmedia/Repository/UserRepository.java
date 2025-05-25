package com.univrouen.socialmedia.Repository;

import com.univrouen.socialmedia.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUserId(String id);

    Optional<User> findUserByUserId(String id);

    List<User> findAllByUserIdIn(List<String> userIds);
}
