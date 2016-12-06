/*
 * Copyright (c) - Darnell Henry - 2016. All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.example.repository;

import com.example.model.User;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;

import java.util.UUID;

public class UserRepositoryImpl extends CassandraCrudRepositoryImpl<User> implements UserRepository {

    public UserRepositoryImpl(CassandraEntityInformation<User, MapId> metadata, CassandraOperations operations)
    {
        super(metadata, operations);
    }
    
    @Override
    public User findById(UUID id) {
        User user = new User();
        user.setUserName("jdoe");
        user.setId(UUID.randomUUID());
        user.setEmail("jdoe@example.com");
        return user;
    }
}
