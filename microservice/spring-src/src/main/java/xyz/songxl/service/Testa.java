package xyz.songxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.songxl.mapper.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * @author songxl
 * @create 2019-07-18 19:58
 * @desc ${DESCRIPTION}
 **/
@Service
public class Testa {

    @Autowired
    private UserMapper userMapper;

    public List<Map> query() {
        return userMapper.query();
    }
}
