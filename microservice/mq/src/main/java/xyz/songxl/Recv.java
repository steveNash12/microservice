package xyz.songxl;

import com.rabbitmq.client.*;
import java.io.IOException;
/**
 * @author songxl
 * @create 2019-03-20 15:27
 * @desc ${DESCRIPTION}
 **/
public class Recv {

    // 队列名称
    private final static String QUEUE_NAME = "helloMQ";

    public static void main(String[] argv) throws Exception {

        // 打开连接和创建频道，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

//                try {
//                    doWork(message);
//                }finally {
//                    System.out.println(" [x] Done");
//                    channel.basicAck(envelope.getDeliveryTag(), false);
//                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }




    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (Character.isDigit(ch)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
//                    _ignored.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
