package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author songxl
 * @create 2018-12-18 20:29
 * @desc ${DESCRIPTION}
 **/
@SpringBootApplication
// 启动服务与注册发现
@EnableDiscoveryClient
// 启用 feign远程调用
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker

public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }
}
