package com.alan.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/27 14:56
 */
@SpringBootApplication
@MapperScan("com.alan.system.mapper")
public class ServiceSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class,args);
    }
}
