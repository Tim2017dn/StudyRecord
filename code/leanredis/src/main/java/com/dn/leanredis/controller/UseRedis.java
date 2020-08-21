package com.dn.leanredis.controller;

import com.dn.leanredis.service.RedisService;
import com.google.gson.Gson;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseRedis {

    @Autowired
    RedisService redis;


    @RequestMapping(value = "/redis/set",method = RequestMethod.POST)
    public String set(@RequestParam("key") String key, @RequestParam("value") String value){
        boolean res = redis.set(key, value);
        Gson gson = new Gson();
        String s = gson.toJson(res+"ok");
        return s;
    }

    @ResponseBody
    @RequestMapping("/redis/get")
    public String get(@Param("key") String key){
        String o = (String) redis.get(key);
        return o;
    }



}
