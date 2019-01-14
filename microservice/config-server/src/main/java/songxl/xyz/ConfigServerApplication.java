package songxl.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author songxl
 * @create 2019-01-09 17:25
 * @desc spring cloud bus 消息总线，每次保存配置文件后 需要手动执行
 * curl -X POST http://localhost:9007/actuator/bus-refresh/
 * 后，配置会在所用的服务中都生效 也可以用postman
 *  具体查看： https://windmt.com/2018/04/19/spring-cloud-9-config-eureka-bus/
 **/

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
