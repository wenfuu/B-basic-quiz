package com.thoughtworks.gtb.service;

import com.thoughtworks.gtb.exception.UserNotFoundException;
import com.thoughtworks.gtb.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Long, User> userMap = new HashMap<>();

    public void createUser(User user) {
        user.setId((long) (userMap.size() + 1));
        userMap.put((long) (userMap.size() + 1), user);
    }

    public User findUserById(Long id) {
        if (userMap.get(id) == null) {
            throw new UserNotFoundException("cannot find this user");
        }
       return userMap.get(id);
    }
}
