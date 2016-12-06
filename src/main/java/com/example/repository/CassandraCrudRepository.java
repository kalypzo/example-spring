/*
 * Copyright (c) - Darnell Henry - 2016. All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CassandraCrudRepository<T> extends CassandraRepository<T> {
    T save(T t, boolean failIfExists);
}
