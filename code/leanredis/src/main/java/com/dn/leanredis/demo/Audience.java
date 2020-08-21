package com.dn.leanredis.demo;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Before("execution(* com.dn.leanredis.demo.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("take seat");
    }


    @Before("execution(* com.dn.leanredis.demo.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @After("execution(* com.dn.leanredis.demo.Performance.perform(..))")
    public void finish() {
        System.out.println("perform finish");
    }

    @AfterReturning("execution(* com.dn.leanredis.demo.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* com.dn.leanredis.demo.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

}
