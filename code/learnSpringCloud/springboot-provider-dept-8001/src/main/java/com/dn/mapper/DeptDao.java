package com.dn.mapper;

import com.dn.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    @Insert("insert into dept(dept_name) values(#{dept_name})")
    boolean addDept(Dept dept);

    @Select("select * from dept where id =#{id}")
    Dept queryByID(Integer id);

    @Select("select * from dept")
    List<Dept> queryAll();
}
