package com.genspringboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genspringboot.project.model.User;
import com.genspringboot.project.service.UserService;

//esto nos permite hacer peticione desde cualquier parte
//no solo desde nuestro servidor local
@CrossOrigin("*")
@RestController
public class UserController {
    
    private UserService userService;

    public UserController (@Autowired UserService userService){
        this.userService = userService;
    }

    

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
    //si no lleva id, agrega
    //si lleva id, pero el id no existe, tambien agrega
    @PostMapping("/user")
    public User newUser(@RequestBody User user){
        return userService.save(user);
    }
    //si lleva id y si el id existe en la base, este lo actualiza con los nuevos datos
    @PutMapping("/user")
    public User updatUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }

    @RequestMapping("/allUser")
    public List<User> getAllUsers(){
        List<User> listaUser = userService.getAllUsers();
        return listaUser;
    }
}
