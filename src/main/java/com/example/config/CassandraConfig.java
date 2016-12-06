package com.example.config;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.example.repository.CassandraCrudRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(repositoryBaseClass = CassandraCrudRepositoryImpl.class)
public class CassandraConfig {

    @Autowired
    private Session session;

    @Bean
    public MappingManager mappingManager() {
        return new MappingManager(session);
    }
}
