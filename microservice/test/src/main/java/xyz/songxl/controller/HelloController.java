package xyz.songxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class HelloController {

    @Autowired
    private  ConsumerRemote consumerRemote;

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
        return consumerRemote.abc();
    }

}
