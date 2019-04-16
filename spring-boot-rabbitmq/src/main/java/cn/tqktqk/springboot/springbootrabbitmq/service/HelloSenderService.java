package cn.tqktqk.springboot.springbootrabbitmq.service;

import cn.tqktqk.springboot.springbootrabbitmq.config.MqFeildConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-16 15:53
 */
@Service
public class HelloSenderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "hello "+ LocalDateTime.now();
        logger.info("send info :"+message);
        amqpTemplate.convertAndSend(MqFeildConst.QUEUE_NAME,message);
    }
}
