/*
 * Copyright (c) - Darnell Henry - 2016. All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.example.repository;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;

public class CassandraCrudRepositoryImpl<T> extends SimpleCassandraRepository<T, MapId> implements CassandraCrudRepository<T> {

    private static final Logger log = LoggerFactory.getLogger(CassandraCrudRepositoryImpl.class);

    @Autowired
    private MappingManager mappingManager;

    @Autowired
    private Session session;

    public CassandraCrudRepositoryImpl(CassandraEntityInformation<T, MapId> metadata, CassandraOperations operations)
    {
        super(metadata, operations);
        log.info("Initializing CassandraCrudRepositoryImpl");
    }
    
    @SuppressWarnings("unchecked")
    public T save(T t, boolean failIfExists) {
        log.info("Calling save with failIfExists");

        Mapper<T> mapper = mappingManager.mapper((Class<T>) t.getClass());
        Insert insert = buildInsertStatement(mapper.saveQuery(t), mapper.getTableMetadata());

        if (!session.execute(insert).wasApplied()) {
            throw new IllegalArgumentException("Data already exists");
        }

        return t;
    }

    private Insert buildInsertStatement(Statement statement, TableMetadata tableMd) {
        BoundStatement boundStatement = (BoundStatement) statement;
        String table = tableMd.getName();
        Insert insert = QueryBuilder.insertInto(boundStatement.getKeyspace(), table).ifNotExists();

        String name;
        Object value;
        for (ColumnDefinitions.Definition col : boundStatement.preparedStatement().getVariables()) {
            name = col.getName();
            value = boundStatement.getObject(name);
            insert.value(name, value);
        }

        return insert;
    }
}
