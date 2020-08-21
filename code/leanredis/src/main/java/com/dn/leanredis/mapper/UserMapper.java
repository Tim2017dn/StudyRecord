package com.dn.leanredis.mapper;

import com.dn.leanredis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Select("select * from user where name = #{name}")
     User finByName(String name);

    boolean insertOneUser(User u);

}
