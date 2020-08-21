package com.dn.service.impl;

import com.dn.mapper.DeptDao;
import com.dn.pojo.Dept;
import com.dn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    DeptDao dao;

    public boolean addDept(Dept dept) {
        return dao.addDept(dept);

    }

    public Dept queryByID(Integer id) {
        return dao.queryByID(id);
    }

    public List<Dept> queryAll() {
        return dao.queryAll();
    }
}
