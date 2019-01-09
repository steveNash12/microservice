package xyz.songxl.abc;

import org.springframework.stereotype.Component;

/**
 * @author songxl
 * @create 2018-12-25 16:11
 * @desc ${DESCRIPTION}
 **/
@Component
public class HelloRemoteHystrix implements HelloRemote{
    @Override
    public String hello(String name) {
        return "hello "+name+" this message send failed";
    }
}
