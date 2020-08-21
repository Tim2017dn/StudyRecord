package com.dn.leanredis.demo;

import com.dn.leanredis.demo.Performance;
import org.springframework.stereotype.Component;

@Component
public class SleepNoMore implements Performance {
    @Override
    public void perform() {
        System.out.println("sleep no more");
    }
}
