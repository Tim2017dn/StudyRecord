package com.dn.leanredis.service;

import com.dn.leanredis.pojo.User;
import com.dn.leanredis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User find(String name){
        User user = userMapper.finByName(name);
        return user;
    }

    public boolean insert(String name,Integer pass){
        User u = User.builder().build();
        u.setName(name);
        u.setPass(pass);
        boolean b = userMapper.insertOneUser(u);
        return b;
    }


}
