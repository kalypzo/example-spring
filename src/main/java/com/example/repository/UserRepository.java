/*
 * Copyright (c) - Darnell Henry - 2016. All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.example.repository;

import com.example.model.User;

public interface UserRepository extends UserRepositoryCustom, CassandraCrudRepository<User> {
    
}
