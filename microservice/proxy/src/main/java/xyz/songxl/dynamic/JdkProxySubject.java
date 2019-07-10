package xyz.songxl.dynamic;

import xyz.songxl.pattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author songxl
 * @create 2019-07-10 15:34
 * @desc jdk 动态代理
 **/
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;
    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic JdkProxySubject");
        Object result = null;
        try {
            // 通过反射 找到调用的方法
            result = method.invoke(realSubject,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            System.out.println("after ");
        }

        return result;
    }
}
