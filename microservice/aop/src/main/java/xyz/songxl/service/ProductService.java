package xyz.songxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.songxl.domain.Product;
import xyz.songxl.security.AdminOnly;

import javax.annotation.Resource;

/**
 * @author songxl
 * @create 2019-07-09 11:48
 * @desc ${DESCRIPTION}
 **/
@Service
public class ProductService {

    @Resource
    private AuthService authService;

    @AdminOnly
    public void insert(Product product) {
        System.out.println("insert product" + product);
    }

    @AdminOnly
    public void delete(Long id) {
        System.out.println("delete product : " +id);
    }
}
