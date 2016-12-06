/*
 * Copyright (c) - Darnell Henry - 2016. All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepo;
    
    public List<User> getUsers() {
        return Lists.newArrayList(userRepo.findAll());
    }

    public User getUserById(UUID id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user, true);
    }
}
