package xyz.songxl.staticp;

import xyz.songxl.pattern.RealSubject;
import xyz.songxl.pattern.Subject;

/**
 * @author songxl
 * @create 2019-07-10 15:17
 * @desc 静态代理  代理类和正式的业务类需要实现同一个接口
 **/
public class StaticProxy implements Subject {

    private RealSubject realSubject;
    public StaticProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public void play() {
        System.out.println("this is proxy");
        try {
            realSubject.play();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sayHi() {
        System.out.println("this is proxy");
        try {
            realSubject.sayHi();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
