package xyz.songxl.service.impl;

import xyz.songxl.service.MessageService;

import java.time.Instant;

/**
 * @author songxl
 * @create 2019-07-24 17:13
 * @desc ${DESCRIPTION}
 **/
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello sxl" + Instant.now();
    }
}
