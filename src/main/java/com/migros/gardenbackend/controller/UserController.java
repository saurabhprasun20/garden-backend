package com.migros.gardenbackend.controller;

import com.migros.gardenbackend.entity.User;
import com.migros.gardenbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins={"http://localhost:3000","http://33339.hostserv.eu:3000","https://migros-gardener.web.app:80"})
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUser(@RequestParam String id){
        System.out.println("id received"+id);
        return userService.getOne(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAll();
    }

}
