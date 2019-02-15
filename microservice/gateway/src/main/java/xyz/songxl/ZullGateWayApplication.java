package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import xyz.songxl.filter.TokenFilter;

/**
 * @author songxl
 * @create 2018-12-18 20:01
 * @desc 服务网关 Zuul（路由）
 * https://windmt.com/2018/04/23/spring-cloud-10-zuul-router/
 *
 **/

@SpringBootApplication
@EnableZuulProxy
public class ZullGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullGateWayApplication.class, args);
    }

    /**
     * 启动过滤器
     * @return
     */
    @Bean
    public TokenFilter TokenFilter() {
        return  new TokenFilter();
    }
}
