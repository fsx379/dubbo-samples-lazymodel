package org.apache.dubbo.samples.lazy.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import org.apache.dubbo.samples.api.client.GreetingService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(version = "${demo.service.version}" )
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greeting(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Greeting " + name +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Greeting " + name + ", response from provider: " +
                RpcContext.getContext().getRemoteAddressString() +"->" +
                RpcContext.getContext().getLocalAddressString();
    }
}
