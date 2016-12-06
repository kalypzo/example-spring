package com.example.repository;

import com.example.model.User;

public interface UserRepository extends UserRepositoryCustom, CassandraCrudRepository<User> {
    
}
