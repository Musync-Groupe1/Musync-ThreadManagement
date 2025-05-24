package com.univrouen.socialmedia.Service.User;

import com.univrouen.socialmedia.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean userExists(String id);

    Map<String, User> getUsersByIds(List<String> userIds);

    User getCurrentUser();

    User getUserById(String id);

    void deleteUserById(String id);

    User saveUser(User user);
}
