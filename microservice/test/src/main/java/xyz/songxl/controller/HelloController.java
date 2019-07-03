package xyz.songxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xyz.songxl.feign.ConsumerRemote;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * @author songxl
 * @create 2018-12-18 20:52
 * @desc ${DESCRIPTION}
 **/
@RestController
@RequestMapping("/hello")
///// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@RefreshScope
public class HelloController {

    @Autowired
    private  ConsumerRemote consumerRemote;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${neo.hello}")
    private String hello;

    @GetMapping("sayHi")
    public String sayHi(@RequestParam("name") String userName,HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        System.out.println(userName + Instant.now() + " port : " + request.getServerPort());
        return "hello 2222~ "+userName;
    }

    @GetMapping("abc")
    public String hystrix(@RequestParam("name") String userName,HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        System.out.println(userName + Instant.now() + " port : " + request.getServerPort());
        Object result = restTemplate.getForObject("http://127.0.0.1:9002/consumer/hello/abc?token=abc&name=123",Object.class);
//        return consumerRemote.abc();
        System.out.println(result.toString());
        return "success";
    }

    @GetMapping("/config")
    public String getConfig() {
        System.out.println("config file : " + this.hello);
        return hello;
    }
}
