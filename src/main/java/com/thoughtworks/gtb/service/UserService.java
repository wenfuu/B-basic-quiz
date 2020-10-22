package com.thoughtworks.gtb.service;

import com.thoughtworks.gtb.exception.UserNotFoundException;
import com.thoughtworks.gtb.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {
    //TODO GTB-知识点: - UserService.java:12 存储相关的细节，可以抽取到repository层做
    private final Map<Long, User> userMap = new HashMap<>();

    public void createUser(User user) {
        //TODO GTB-工程实践: - UserService.java:16 可以试试Long.valueOf()
        //TODO GTB-工程实践: - UserService.java:17 线程不安全，这种内存中自增可以试试AtomicInteger
        user.setId((long) (userMap.size() + 1));
        userMap.put((long) (userMap.size() + 1), user);
    }

    public User findUserById(Long id) {
        //TODO GTB-工程实践: - UserService.java:23 可以试试Objects.isNull()，可读性更高
        if (userMap.get(id) == null) {
            throw new UserNotFoundException("cannot find this user");
        }
       return userMap.get(id);
    }
}
