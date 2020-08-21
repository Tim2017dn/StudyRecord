package com.dn.controller;

import com.dn.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
@Controller
public class DeptConsumerController {

    @Autowired
    private RestTemplate template;


    private static final String PREFIX = "http://localhost:8001";

    @RequestMapping("/consume/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") Integer id){
        return template.getForObject(PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consume/add")
    @ResponseBody
    public Dept add( String dept_name){
        Dept dept = new Dept(dept_name);
        return template.postForObject(PREFIX+"/dept/add/",dept,Dept.class);
    }





}
