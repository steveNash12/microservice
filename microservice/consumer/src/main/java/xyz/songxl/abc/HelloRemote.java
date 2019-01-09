package xyz.songxl.abc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author songxl
 * @create 2018-12-25 12:05
 * @desc ${DESCRIPTION}
 **/
@FeignClient(name = "test",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping(value = "/test/hello/sayHi")
    public String hello(@RequestParam("name") String name);

}
