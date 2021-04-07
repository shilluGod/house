package com.shillu.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/2/21 15:29
 */
@SpringBootApplication
@MapperScan("com.shillu.server.mapper")     //扫描，指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类是在Springboot启动类上面添加。
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class,args);
    }
}
