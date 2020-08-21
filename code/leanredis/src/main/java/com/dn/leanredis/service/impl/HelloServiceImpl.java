package com.dn.leanredis.service.impl;

import com.dn.leanredis.service.HelloService;

public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String name) {
        if( name == null || name.trim() == ""){
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello "+name);
    }

    @Override
    public void sayNo() {
        System.out.println("no");
    }
}
