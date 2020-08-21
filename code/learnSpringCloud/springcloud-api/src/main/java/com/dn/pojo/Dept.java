package com.dn.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor()
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dept_name;
    private String db_source;

    public Dept(String dept_name) {
        this.dept_name = dept_name;
    }
}


