package xyz.songxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("hello/{name}")
    public String index(@PathVariable("name") String name) {
        System.out.println(name);
        return helloRemote.hello(name);
    }

    @GetMapping("/hello/abc")
    public String abc() {
        System.out.println("hystrix" + Instant.now());
        return "success";
    }
}
