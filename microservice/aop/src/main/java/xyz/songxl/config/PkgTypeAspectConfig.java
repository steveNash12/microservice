package xyz.songxl.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author songxl
 * @create 2019-07-09 19:59
 * @desc ${DESCRIPTION}
 **/

@Aspect // 标明这是一个切面
@Component
public class PkgTypeAspectConfig {

    @Pointcut("within(xyz.songxl.service.ProductService)") // 匹配ProductService 类里面的所有方法
    public void matchMethod(){
    }
    @Pointcut("within(xyz.songxl.service.sub.*)") // 匹配 sub 包下面所有类的所有方法
    public void matchPackage(){
    }
    // 匹配所有以 service 结尾的bean 里面的方法
    @Pointcut("bean(*Service)")
    public void matchBean(){}

    // 过滤出只有一个参数 且参数类型是long的方法
    @Pointcut("args(Long)")
    public void mathArgs(){

    }
    // 过滤出只有一个参数 且参数类型是long的方法 并且是 ProductService 类里面的方法
    @Pointcut("args(Long) && within(xyz.songxl.service.ProductService)")
    public void mathArgs2(){

    }
    // 匹配 标有 AdminOnly 注解的方法
    @Pointcut("@annotation(xyz.songxl.security.AdminOnly)")
    public void adminOnly() {

    }
    // 匹配标注有beta 类的方法 要求的annotation 的RetentionPolicy 级别为 class
//    @Pointcut("@within(com.google.common.annotations.Beta)")
//    public void matchAnnoWithin(){
//
//    }

    // 匹配标注有Repository 类的方法  要求的annotation 的RetentionPolicy 级别为runtime
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void matchAnnoTarge(){

    }

    // 匹配传入的参数标注有Repository注解的方法
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void matchAnnoArgs(){
    }


    @Before("matchMethod()")
    public void before() {
        System.out.println("before matchMethod");
    }

    @After("matchPackage()")
    public void after(){
        System.out.println("after matchPackage");
    }



}
