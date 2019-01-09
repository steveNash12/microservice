package xyz.songxl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.songxl.hystrix.ConsumerRemoteHystrix;

/**
 * @author songxl
 * @create 2019-01-02 20:29
 * @desc ${DESCRIPTION}
 **/

@FeignClient(name ="consumer",fallback = ConsumerRemoteHystrix.class)
public interface ConsumerRemote {

    @RequestMapping("/hello/abc")
    public String abc();

}
