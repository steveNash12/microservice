package xyz.songxl.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * @author songxl
 * @create 2019-03-21 16:26
 * @desc  发送消息
 **/
@RestController()
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(String msg) {

        System.out.println("Sender:" +msg + " : " + Instant.now());
        this.rabbitmqTemplate.convertAndSend(RabbitMQConfig.TEST_QUEUE,msg);
        return "SUCCESS";
    }
}
