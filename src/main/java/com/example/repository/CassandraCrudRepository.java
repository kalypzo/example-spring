package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CassandraCrudRepository<T> extends CassandraRepository<T> {
    T save(T t, boolean failIfExists);
}
