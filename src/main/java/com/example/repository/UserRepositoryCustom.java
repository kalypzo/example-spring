package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface UserRepositoryCustom {
    
    User findById(UUID id);
    
}
