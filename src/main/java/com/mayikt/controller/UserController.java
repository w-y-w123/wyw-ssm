package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    @GetMapping("/getById/{id}")
    public UserEntity getById ( @PathVariable("id") Integer id){
        return  userService.getById(id);
    }
    @PostMapping("/insertUser")
    public int insertUser(@RequestBody UserEntity userEntity){
     return   userService.insertUser(userEntity);
    }
    @DeleteMapping("/deleteById/{id}")
    public int  deleteById (@PathVariable("id") Integer id ){
        return  userService.deleteById(id);
    }
    @PutMapping("updateUser")
    public int updateUser(@RequestBody UserEntity userEntity){
        return userService.updateUser(userEntity);
    }
}
