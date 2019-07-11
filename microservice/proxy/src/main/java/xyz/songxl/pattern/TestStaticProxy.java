package xyz.songxl.pattern;

import xyz.songxl.dynamic.JdkProxySubject;
import xyz.songxl.staticp.StaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author songxl
 * @create 2019-07-10 20:45
 * @desc ${DESCRIPTION}
 **/
public class TestStaticProxy {

    public static void main(String[] args) {

        Subject jdkProxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        jdkProxy.play();
        jdkProxy.sayHi();

    }
}
