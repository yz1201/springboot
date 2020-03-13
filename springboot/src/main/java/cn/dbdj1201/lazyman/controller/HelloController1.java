package cn.dbdj1201.lazyman.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tyz1201
 * @datetime 2020-03-13 16:48
 **/
@RestController
@RequestMapping("/hello")
public class HelloController1 {

    @GetMapping("test1")
    public String test() {
        return "hello springboot 2";
    }

}
