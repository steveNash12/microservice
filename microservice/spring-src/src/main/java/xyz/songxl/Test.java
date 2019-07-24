package xyz.songxl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;
import xyz.songxl.conf.SpringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songxl
 * @create 2019-07-18 20:03
 * @desc ${DESCRIPTION}
 **/
@SpringBootApplication
public class Test {

    @Autowired
    public static void main(String[] args) {


//        String[] str = new String[]{"a","b","c"};
//        List<String> list = Arrays.asList(str);
////        list.add("d");
//        System.out.println(Arrays.asList().getClass());
//        System.out.println(new ArrayList().getClass());
       /* List list1 = new ArrayList(0);
        list1.add("a");
        Object[] objects = new Object[10];
        objects[0] = "aa";
        objects[1] = 2.3;
        List list2 = new ArrayList(objects);
        list2.add(new Object());*/

        SpringApplication.run(Test.class, args);
        System.out.println(SpringUtil.getBean("testa"));
        System.out.println(SpringUtil.getBean("@songxlFactoryBean"));
    }


    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }
}
