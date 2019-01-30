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
 * @desc ${DESCRIPTION}
 **/

@SpringBootApplication
@EnableZuulProxy
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
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
