package com.dn.leanredis;

import com.dn.leanredis.config.LogConfig;
import com.dn.leanredis.demo.*;
import com.dn.leanredis.intercept.MyInterception;
import com.dn.leanredis.proxy.ProxyBean;
import com.dn.leanredis.service.HelloService;
import com.dn.leanredis.service.UserService;
import com.dn.leanredis.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

@SpringBootTest
@EnableAsync
@Slf4j
class LeanredisApplicationTests {


    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    AsyncDemo asyncDemo;

    @Autowired
    Task task;

    @Autowired
    Task2 t2;

    @Test
    void contextLoads() {
        // test2();

    }

    @Test
    public void test1() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");

       while(resultSet.next()){
           System.out.println(resultSet.getString("name"));
       }

    }

    @Test
    public void test2(){


        boolean bool = userService.insert("zhang", 1234);
        System.out.println(bool);
    }


    @Test
    public void test3(){
        HelloService helloService =new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterception());
                  proxy.sayHello("zhangsan");

        System.out.println("=======================");
        proxy.sayHello(null);
    }

    @Test
    public void test4(){
        HelloService helloService =new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterception());
        proxy.sayNo();

        System.out.println("=======================");

    }

    @Test
    public void test5() throws InterruptedException {
        asyncDemo.test1();
        asyncDemo.test2("hello");
    }

    @Test
    public void test6() throws Exception {

//        task.doTaskOne();
//        task.doTaskTwo();
//        task.doTaskThree();

        long start = System.currentTimeMillis();
        CountDownLatch threejob = new CountDownLatch(3);

        new Thread(()->{
            try {
                task.doTaskOne();
                threejob.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                task.doTaskTwo();
                threejob.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                task.doTaskThree();
                threejob.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        threejob.await();
        long end = System.currentTimeMillis();


        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }

    @Test
    public void test7() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = t2.doTaskOne();
        Future<String> task2 = t2.doTaskTwo();
        Future<String> task3 = t2.doTaskThree();

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }

    @Autowired
    Performance per;

    @Test
    public void test8(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LogConfig.class);

        //Performance performance = context.getBean(SleepNoMore.class);
        //performance.perform();
        per.perform();
        context.close();

    }

    @Test
    public void test9(){
        log.info("这是一个测试");

    }



}
