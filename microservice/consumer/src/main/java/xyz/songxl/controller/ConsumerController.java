package xyz.songxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.songxl.abc.HelloRemote;

import java.time.Instant;

/**
 * @author songxl
 * @create 2018-12-25 14:32
 * @desc ${DESCRIPTION}
 **/
@RestController
///// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@RefreshScope
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("hello/{name}")
    public String index(@PathVariable("name") String name) {
        System.out.println(name);
        return helloRemote.hello(name);
    }

    @GetMapping("/hello/abc")
    public String abc() {
        System.out.println("hystrix" + Instant.now());
        System.out.println(this.hello);
        return hello;
    }
}
