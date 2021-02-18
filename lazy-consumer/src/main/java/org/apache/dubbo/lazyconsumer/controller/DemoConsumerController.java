package org.apache.dubbo.lazyconsumer.controller;

import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.config.annotation.Reference;

import org.apache.dubbo.samples.api.client.GoodbyeService;
import org.apache.dubbo.samples.api.client.GreetingService;
import org.apache.dubbo.samples.api.client.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private HelloService helloService;

    @Reference(version = "${demo.service.version}")
    private GreetingService greetingService;

    @Reference(version = "${demo.service.version}")
    private GoodbyeService goodbyeService;


    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        String ret = helloService.sayHello(name);
        System.out.println("[sayHello] " + ret);
        return ret;
    }

    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable("name") String name) {
        String ret = greetingService.greeting(name);
        System.out.println("[greeting] " + ret);
        return ret;
    }

    @RequestMapping("/goodbye/{name}")
    public String goodbye(@PathVariable("name") String name) {
        String ret = goodbyeService.goodbye(name);
        System.out.println("[goodbye] " + ret);
        return ret;
    }


}
