package com.genspringboot.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.genspringboot.project.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
