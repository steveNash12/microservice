package xyz.songxl.pattern;

/**
 * @author songxl
 * @create 2019-07-10 15:16
 * @desc ${DESCRIPTION}
 **/

public class RealSubject implements Subject {
    @Override
    public void play() {
        System.out.println("this is RealSubject");
    }

    @Override
    public void sayHi() {
        System.out.println("hello, everyone this is RealSubject");
    }
}
