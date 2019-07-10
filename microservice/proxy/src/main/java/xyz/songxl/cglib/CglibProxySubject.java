package xyz.songxl.cglib;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author songxl
 * @create 2019-07-10 17:13
 * @desc cglib 动态代理模式
 **/
public class CglibProxySubject implements MethodInterceptor {
    /**
     * jdk 与cglib 代理对比
     * jdk 只能针对实现了接口类方法的方法进行动态代理
     * cglib 基于继承来实现代理，无法对static final 类进行代理
     * cglib 基于继承来实现代理，无法对 private static 方法进行代理
     */


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxySubject");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o,objects);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
