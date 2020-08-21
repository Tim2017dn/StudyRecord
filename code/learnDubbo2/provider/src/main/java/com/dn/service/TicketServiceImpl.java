package com.dn.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class TicketServiceImpl implements TIcketService {


    public String getTicket() {
        return "TICKET1";
    }
}
