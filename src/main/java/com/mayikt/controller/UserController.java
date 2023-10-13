package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired(required = false)
    private UserService userService;
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById (@PathVariable("id") Integer id){
    if (id==null){
        return setResultError("id is null");
    }
        UserEntity user = userService.getById(id);
    if (user==null){
        return setResultError("user is null");
    }
        return setResultok(user);
    }
    @PostMapping("/insertUser")
    public HashMap<String, Object> insertUser(@RequestBody UserEntity userEntity){
     return   userService.insertUser(userEntity)>0?
             setResultSuccess("插入成功"):setResultError("插入数据失败！");
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
