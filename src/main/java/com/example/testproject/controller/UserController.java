package com.example.testproject.controller;


import com.example.testproject.model.User;
import com.example.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private User addUser(@RequestBody User user){

        return userService.save(user);

    }
    @PostMapping("/add/file")
    private User addImageToUser(@RequestParam Long userId, @RequestPart MultipartFile file){

        User user = userService.getById(userId);
        return userService.addUser(user,file);

    }
}
