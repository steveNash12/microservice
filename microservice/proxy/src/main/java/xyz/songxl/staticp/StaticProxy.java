package xyz.songxl.staticp;

import xyz.songxl.pattern.RealSubject;
import xyz.songxl.pattern.Subject;

/**
 * @author songxl
 * @create 2019-07-10 15:17
 * @desc 静态代理
 **/
public class StaticProxy implements Subject {

    private RealSubject realSubject;
    public StaticProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public void request() {
        System.out.println("this is proxy");

        try {
            realSubject.request();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("after proxy ");
        }
    }

    @Override
    public void sayHi() {
        System.out.println("this is proxy");

        try {
            realSubject.request();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("after proxy ");
        }
    }
}
