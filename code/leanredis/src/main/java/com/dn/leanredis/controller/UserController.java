package com.dn.leanredis.controller;

import com.dn.leanredis.pojo.User;
import com.dn.leanredis.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String find(@RequestParam("name") String name){
        User user = userService.find(name);
        Gson g =new Gson();
        return g.toJson(user);

    }

    @RequestMapping(value = "/user/insert")
    @ResponseBody
    public String insert(){
        boolean bool = userService.insert("zhang", 1234);
        Gson g =new Gson();
        return g.toJson(bool);

    }

   @RequestMapping(value = "/setCookie",method = RequestMethod.GET)
    public String setCookie(HttpServletResponse response){

        Cookie cookie = new Cookie("sessionId","zhangsan");
        response.addCookie(cookie);
        return "User name changed";
    }

    @RequestMapping(value = "/getCookie",method =  RequestMethod.GET)
    public String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("sessionId")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }



    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("sessionId") String sessionId ) {
        //前提是已经创建了或者已经存在cookie了，那么下面这个就直接把对应的key值拿出来了。
        System.out.println("testCookieValue,sessionId=" + sessionId);


        return "SUCCESS";
    }



}
