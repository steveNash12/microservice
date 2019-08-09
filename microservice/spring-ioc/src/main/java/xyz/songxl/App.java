package xyz.songxl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.songxl.service.MessageService;

/**
 * @author songxl
 * @create 2019-07-24 17:17
 * @desc ${DESCRIPTION}
 **/
public class App {

    public static void main(String[] args) {
        // 手动加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("启动成功");
//        context.getBean(MessageServiceImpl.class);
//        context.getBean()
//        System.out.println(context.getApplicationName());
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());
        System.out.println(((MessageService)context.getBean("messageService")).getMessage());

    }
}
