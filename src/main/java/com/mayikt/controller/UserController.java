package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public Map<String, Object> deleteById (@PathVariable("id") Integer id ){
        int i1=userService.deleteById(id);
        return i1 >0 ?  setResultSuccess("删除成功"):setResultError("删除失败");
    }
    @PutMapping("updateUser")
    public Map<String, Object> updateUser(@RequestBody UserEntity userEntity){
        int i = userService.updateUser(userEntity);
        return i>0 ? setResultSuccess("ok") : setResultError("更新数据失败");
    }
    @GetMapping("/getUsersAll")
    public Map<String,Object> getUsersAll(){
        List<UserEntity> userEntities = userService.getUsersAll();
        return  setResultok(userEntities) ;
    }
}
