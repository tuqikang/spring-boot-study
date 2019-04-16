package cn.tqktqk.springboot.springbootrabbitmq.service;

import cn.tqktqk.springboot.springbootrabbitmq.config.MqFeildConst;
import cn.tqktqk.springboot.springbootrabbitmq.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-16 15:56
 */
@Service

public class HelloReceiverService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitHandler
    @RabbitListener(queues = MqFeildConst.QUEUE_NAME)
    public void process(UserInfo userInfo){
//        logger.info("Receiver  : " + message);
        logger.info(userInfo.toString());
    }

    //接收者
    @RabbitHandler
    @RabbitListener(queues = "ONE")
    public void process1(String s) {
        logger.info("Receiver ONE message : " + s);
    }

    //接收者
    @RabbitHandler
    @RabbitListener(queues = "TWO")
    public void process2(String s) {
        logger.info("Receiver TWO message : " + s);
    }
}
