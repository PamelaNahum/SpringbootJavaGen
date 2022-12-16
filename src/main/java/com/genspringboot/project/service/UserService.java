package com.genspringboot.project.service;

import java.util.List;

import com.genspringboot.project.model.User;

public interface UserService {

    User getUser(Integer id);

    User save (User user);

    void delete(Integer id);

    List<User> getAllUsers();
}
