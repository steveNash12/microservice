package xyz.songxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songxl
 * @create 2019-03-22 14:54
 * @desc spring boot 快速集成 rabbitmq demo
 * https://blog.csdn.net/sessionsong/article/details/88743077
 *
 **/
@SpringBootApplication
public class MQ2Application {
    public static void main(String[] args) {
        SpringApplication.run(MQ2Application.class,args);
    }
}
