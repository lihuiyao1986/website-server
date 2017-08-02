package com.lys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jk on 17/8/1.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lys.dao.mapper")
public class Applications {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Applications.class, args);
    }

}
