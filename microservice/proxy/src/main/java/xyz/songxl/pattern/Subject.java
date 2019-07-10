package xyz.songxl.pattern;

/**
 * @author songxl
 * @create 2019-07-10 15:15
 * @desc  代理模式 代理类和正式的业务类需要实现同一个接口
 **/
public interface Subject {

    public void request();

    public void sayHi();
}
