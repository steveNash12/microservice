package xyz.songxl.service;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.songxl.AopApplication;
import xyz.songxl.domain.Product;
import xyz.songxl.security.CurrentUserHolder;
import xyz.songxl.service.sub.SubService;

import java.util.Currency;

import static org.junit.Assert.*;

/**
 * @author songxl
 * @create 2019-07-09 14:18
 * @desc ${DESCRIPTION}
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AopApplication.class})
//@SpringBootApplication
public class ProductServiceTest {

 /*   advice 5种注解
    1. @Before 之前
    2. @After(finally)
    3. @AfterReturning
    4 @AfterThrowing
    5 @Around
*/
    @Autowired
    ProductService productService;
    @Autowired
    SubService subService;
    @Test
    public void insert() {
        CurrentUserHolder.set("admin");
        Product product = new Product();
        product.setId(1L);
        product.setName("1 test");
        productService.insert(product);
    }
    // 异常test
    @Test(expected = Exception.class)
    public void insertNoAdmin() {
        CurrentUserHolder.set("paul");
        Product product = new Product();
        product.setId(1L);
        product.setName("1 paul");
        productService.insert(product);
    }


    @Test
    public void test() {

        CurrentUserHolder.set("admin");
        Product product = new Product();
        product.setId(1L);
        product.setName("1 test");
        productService.insert(product);
        System.out.println();
        productService.delete(1L);
        System.out.println();
        subService.demo();
    }
}