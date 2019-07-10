package xyz.songxl.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.songxl.service.AuthService;

/**
 * @author songxl
 * @create 2019-07-09 11:54
 * @desc ${DESCRIPTION}
 **/

@Aspect
@Component
public class SecurityAspert {

    @Autowired
    AuthService authService;
    //注解匹配
    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly() {
//        System.out.println("Pointcut(\"@annotation(AdminOnly)\")");
    }
    @Before("adminOnly()")
    public void check() {
        System.out.println("check");
        authService.checkAccess();
    }

}
