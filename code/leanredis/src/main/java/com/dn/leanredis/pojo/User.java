package com.dn.leanredis.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    Integer id;
    String name;
    Integer pass;

    public User(){};

    public User(Integer id,String name,Integer pass){
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

}
