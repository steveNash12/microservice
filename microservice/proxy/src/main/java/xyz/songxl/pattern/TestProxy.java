package xyz.songxl.pattern;

import net.sf.cglib.proxy.Enhancer;
import xyz.songxl.cglib.CglibProxySubject;
import xyz.songxl.dynamic.JdkProxySubject;
import xyz.songxl.staticp.StaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author songxl
 * @create 2019-07-10 15:20
 * @desc ${DESCRIPTION}
 **/
public class TestProxy {


    public static void main(String[] args) {
        // 静态代理模式  实现类和代理类实现相同的接口，代理类调用实现类的方法，不做业务
        // 缺点： 每个需要代理的方法都需要手动去写代理方法 对于方法比较多的情况下，会有很多的重复工作
        // 所以动态代理 出现了
        Subject staticProxy = new StaticProxy(new RealSubject());
        staticProxy.play();
        staticProxy.sayHi();

        System.out.println();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true"); // 保存生成的字节码
        // jdk动态代理
        Subject jdkProxy = (Subject) Proxy.newProxyInstance(TestProxy.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        jdkProxy.play();
        jdkProxy.sayHi();
        System.out.println();
        // cglib 动态代理
        Enhancer enhancer = new Enhancer();
        // 设置真实的业务类
        enhancer.setSuperclass(RealSubject.class);
        // 需要置入的代码类（代理类）
        enhancer.setCallback(new CglibProxySubject());
        // 创建代理实例
        Subject cglibProxy = (Subject) enhancer.create();
        cglibProxy.sayHi();

        /**
         * spring aop jdk 与cglib 动态代理对比
         * jdk 只能针对实现了接口类方法的方法进行动态代理
         * cglib 基于继承来实现代理，无法对static final 类进行代理
         * cglib 基于继承来实现代理，无法对 private static 方法进行代理
         */

    }
}
