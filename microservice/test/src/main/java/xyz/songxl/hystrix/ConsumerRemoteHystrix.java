package xyz.songxl.hystrix;

import org.springframework.stereotype.Component;
import xyz.songxl.feign.ConsumerRemote;

/**
 * @author songxl
 * @create 2019-01-02 20:32
 * @desc ${DESCRIPTION}
 **/
@Component
public class ConsumerRemoteHystrix implements ConsumerRemote {
    @Override
    public String abc() {

        return "hystrix failed";
    }
}
