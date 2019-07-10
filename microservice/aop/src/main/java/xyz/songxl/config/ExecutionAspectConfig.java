package xyz.songxl.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author songxl
 * @create 2019-07-10 14:36
 * @desc Execution 的使用
 **/

@Aspect
@Component
public class ExecutionAspectConfig {

    // 拦截 service 包下 以Service 结尾的类和子包里面的所有方法
    @Pointcut("execution(public * xyz.songxl.service.*Service.*(..))")
    public void matchCondition() {

    }
    @Before("matchCondition()")
    public void before() {
        System.out.println("matchCondition  execution(public * xyz.songxl.service.*Service.*(..))");
    }
}
