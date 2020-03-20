package com.mall.admincenter.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(value = "com.mall.admincenter.dal.dao")
@ComponentScan(value = "com.mall.admincenter")
@ImportResource(value = {"classpath:dubbo.xml"})
public class AdmincenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmincenterServerApplication.class, args);
    }

}
