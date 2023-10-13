package com.mayikt.controller;

import java.util.HashMap;
//处理请求失败的情况下
public class BaseController {
    //提供处理请求成功的情况下
    public HashMap<String,Object> setResultok(Object data){
        return setResult(200,"ok",data);
    }
    public HashMap<String,Object> setResultSuccess(String msg){
        return setResult(200,msg,null);
    }


    public HashMap<String,Object> setResultError(String msg){
    return setResult(500,msg,null);
    }
    public HashMap<String,Object> setResult(Integer code,String msg,Object data){
    HashMap<String,Object> result=new HashMap<>();
    result.put("code",code);
    result.put("msg",msg);
    result.put("data",data);
    return result;
    }
}
