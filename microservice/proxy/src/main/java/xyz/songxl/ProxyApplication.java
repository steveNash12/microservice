package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author songxl
 * @create 2019-07-10 18:00
 * @desc ${DESCRIPTION}
 **/
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}
