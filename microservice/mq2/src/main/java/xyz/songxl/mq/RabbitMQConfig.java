package xyz.songxl.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songxl
 * @create 2019-03-21 16:37
 * @desc RabbitMQ 配置
 **/
@Configuration
public class RabbitMQConfig {

    public static final String TEST_QUEUE = "test";
    @Bean
    Queue workbenchQueue() {
//        new Queue 如果参数完全一致，会直接返回成功，不创建，不一致返回创建失败，不存在会新建
        return new Queue(TEST_QUEUE);
    }
}
