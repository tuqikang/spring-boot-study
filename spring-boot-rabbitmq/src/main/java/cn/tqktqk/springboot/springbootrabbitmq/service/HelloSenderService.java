package cn.tqktqk.springboot.springbootrabbitmq.service;

import cn.tqktqk.springboot.springbootrabbitmq.config.MqFeildConst;
import cn.tqktqk.springboot.springbootrabbitmq.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private RabbitTemplate rabbitTemplate;

    public void send(UserInfo userInfo){
//        String message = "hello "+ LocalDateTime.now();
//        logger.info("send info :"+message);
//        rabbitTemplate.convertAndSend(MqFeildConst.QUEUE_NAME,message);
        logger.info(userInfo.toString());
        rabbitTemplate.convertAndSend(MqFeildConst.QUEUE_NAME,userInfo);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message.one", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message.two", context);
    }
}
