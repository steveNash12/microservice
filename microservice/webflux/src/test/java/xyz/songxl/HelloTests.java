package xyz.songxl;

import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import xyz.songxl.controller.HelloController;

/**
 * @author songxl
 * @create 2019-02-15 15:39
 * @desc webflux 测试
 **/
@RunWith(SpringRunner.class)
@WebFluxTest(controllers=HelloController.class)
public class HelloTests {

    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {

        client.get().uri("/hello").exchange().expectStatus().isOk();

    }
}
