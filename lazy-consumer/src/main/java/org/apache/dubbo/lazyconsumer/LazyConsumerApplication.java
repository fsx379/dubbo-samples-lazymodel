package org.apache.dubbo.lazyconsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class LazyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyConsumerApplication.class, args);
    }

}
