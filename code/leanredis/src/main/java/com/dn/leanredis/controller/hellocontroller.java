package com.dn.leanredis.controller;

import com.dn.leanredis.pojo.User;
import com.dn.leanredis.dto.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @RequestMapping("/hello")
    public String sayhello(){
        return "hello";
    }

    @RequestMapping("/getUser")
    public Object getAUser(){
        User build = User.builder().build();
        build.setName("zhangsan");
        build.setPass(1122);
        return build.toString();

    }

    @ResponseBody
    @RequestMapping("/getResponse")
    public Response getRep(){

        Response rep = new Response();
        rep.setSuccess(true);
        rep.setCode(200);
        rep.setData("数据");
        rep.setMsg("success");

        return rep;


    }



}
