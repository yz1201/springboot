package cn.dbdj1201.lazyman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tyz1201
 * @datetime 2020-03-13 16:59
 * 整个应用的引导类
 **/
//@EnableAutoConfiguration
//@ComponentScan  //默认扫描当前类所在包
@SpringBootApplication //这个注解为组合注解，相当于上边俩还多，+@SpringBootConfiguration
public class ApplicationThis {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationThis.class, args);
    }
}
