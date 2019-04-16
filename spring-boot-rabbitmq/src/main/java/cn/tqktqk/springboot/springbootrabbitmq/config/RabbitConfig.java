package cn.tqktqk.springboot.springbootrabbitmq.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

    @Bean
    public Queue toTopicQueueOne(){
        return new Queue(MqFeildConst.MESSAGE_ONE);
    }

    @Bean
    public Queue toTopicQueueTwo(){
        return new Queue(MqFeildConst.MESSAGE_TWO);
    }

    /**
     * 设置Topic交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 绑定队列
     * @param toTopicQueueOne 根据上面的bean名设置属性名
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeToQueueOne(Queue toTopicQueueOne, TopicExchange exchange){
        //三个参数：1.绑定toTopicQueueOne2.交换机是exchange---TopicExchange3.配置队列的规则*：通配一个标志，#：0个或者多个
        return BindingBuilder.bind(toTopicQueueOne).to(exchange).with("topic.message.one");
    }

    /**
     * 详细讲：首先交换机和队列绑定，并且指定该队列接收->路由建规则符合topic.#的消息。
     * 上面方法同理，但是上面是指定的一个完整的路由建即只会收到符合那个路由建的消息，而这个是一个topic.开头的都能通配的
     * @param toTopicQueueTwo
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeToQueueTwo(Queue toTopicQueueTwo, TopicExchange exchange){
        return BindingBuilder.bind(toTopicQueueTwo).to(exchange).with("topic.#");
    }

}
