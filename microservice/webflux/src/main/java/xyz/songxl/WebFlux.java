package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * @author songxl
 * @create 2019-02-14 18:59
 * @desc ${DESCRIPTION}
 **/
@SpringBootApplication
// 启动服务与注册发现
@EnableDiscoveryClient
public class WebFlux {

    public static void main(String[] args) {
        SpringApplication.run(WebFlux.class,args);
    }
}
