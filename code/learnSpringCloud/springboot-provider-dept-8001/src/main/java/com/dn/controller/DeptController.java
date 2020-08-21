package com.dn.controller;


import com.dn.pojo.Dept;
import com.dn.service.DeptService;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Qualifier("deptServiceImpl")
    @Autowired
    private DeptService service;




    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Integer id){
        return service.queryByID(id);
    }
    @GetMapping("/dept/getall")
    public List<Dept> getall(){
        return service.queryAll();
    }

    @GetMapping("/dept/service")
    public Object discovery(){


    }



}
