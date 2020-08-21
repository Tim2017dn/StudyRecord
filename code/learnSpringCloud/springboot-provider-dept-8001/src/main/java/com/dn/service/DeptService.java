package com.dn.service;

import com.dn.mapper.DeptDao;
import com.dn.pojo.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {


    boolean addDept(Dept dept);

    Dept queryByID(Integer id);

    List<Dept> queryAll();

}
