package com.dn;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class UserAppTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void test1(){

        System.out.println(dataSource);
    }

}
