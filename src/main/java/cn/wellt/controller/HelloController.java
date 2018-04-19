package cn.wellt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caojingchen on 2018/4/19.
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    @RequestMapping(value = "/")
    public String hello(){
        return "Hello World";
    }
}
