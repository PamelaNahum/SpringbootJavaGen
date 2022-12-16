package com.genspringboot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genspringboot.project.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
