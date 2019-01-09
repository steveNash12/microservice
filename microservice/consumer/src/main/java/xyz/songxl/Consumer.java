package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author songxl
 * @create 2018-12-25 11:56
 * @desc ${DESCRIPTION}
 **/
@SpringBootApplication
@EnableDiscoveryClient
// 启用feign进行远程调用
@EnableFeignClients
// 启用Hystrix Dashboard功能。
@EnableHystrixDashboard
@EnableCircuitBreaker
public class Consumer {

    public static void main(String[] args) {

        SpringApplication.run(Consumer.class,args);
    }
}

