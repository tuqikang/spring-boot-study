package cn.tqktqk.springboot.springbootrabbitmq.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-16 15:50
 */
@Configuration
public class RabbitConfig {


    @Bean
    public Queue queue(){
        return new Queue(MqFeildConst.QUEUE_NAME);
    }
}
