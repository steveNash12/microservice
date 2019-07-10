package xyz.songxl.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.songxl.security.CurrentUserHolder;

/**
 * @author songxl
 * @create 2019-07-09 11:52
 * @desc ${DESCRIPTION}
 **/
@Component
public class AuthService {

    public void checkAccess() {
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user)) {
            throw new RuntimeException("operation not allow");
        }
    }
}
