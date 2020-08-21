package com.dn.leanredis.config;

import com.dn.leanredis.demo.Audience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public void logMethod() {
        LOG.info("==========print log==========");

    }

    @Bean
    public Audience newAudience(){
        return new Audience();
    }

}
