package com.nj.secretary;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecretaryApplication {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println("path : "+path);
        SpringApplication.run(SecretaryApplication.class, args);

    }

}
