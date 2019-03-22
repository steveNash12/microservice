package xyz.songxl.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author songxl
 * @create 2019-03-21 16:28
 * @desc 接听
 **/
@Component
@RabbitListener(queues = RabbitMQConfig.TEST_QUEUE)
public class Receiver {

    @RabbitHandler
    public void process(String msg){
        try {
            Thread.sleep(10000); // 为了更好的看到效果  做了10s 的延时
            System.out.println("Receiver:" + msg + " : " + Instant.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
