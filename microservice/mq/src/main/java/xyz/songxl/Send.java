package xyz.songxl;

import java.time.Instant;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author songxl
 * @create 2019-03-20 15:25
 * @desc ${DESCRIPTION}
 **/
public class Send {

    //队列名称
    private final static String QUEUE_NAME = "helloMQ";

    public static void main(String[] argv) throws java.io.IOException, TimeoutException
    {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost("localhost");
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个频道
        Channel channel = connection.createChannel();
        //指定一个队列
        boolean durable = true; // 队列持久化
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        for (int i = 0; i < 5; i++) {
            //发送的消息
            String message = "hello world! " +i;
            //往队列中发出一条消息  PERSISTENT_TEXT_PLAIN 消息持久化
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }

        //关闭频道和连接
        channel.close();
        connection.close();
    }
}
