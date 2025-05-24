package com.univrouen.socialmedia.Service.User;

import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StdUserService implements UserService {
    private final UserRepository userRepository;

    public StdUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(String id) {
        return this.userRepository.existsUserByUserId(id);
    }

    public Map<String, User> getUsersByIds(List<String> userIds) {
        List<User> users = userRepository.findAllByUserIdIn(userIds);
        return users.stream()
                .collect(Collectors.toMap(
                        User::getUserId,
                        user -> user
                ));
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = this.userRepository.findUserByUserId(authentication.getName());
        if (user.isEmpty())
            throw new IllegalArgumentException("User not found");
        return user.get();
    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.findUserByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public void deleteUserById(String id) {
        User user = this.userRepository.findUserByUserId(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        this.userRepository.delete(user);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }
}
