package cn.tqktqk.springboot.springbootkafka.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-05-24 09:34
 */
@Service
public class MsgConsumerService {

    private static final Logger log = LoggerFactory.getLogger(MsgConsumerService.class);

    @KafkaListener(topics = {"topic-1","topic-2"})
    public void processMessage(String content) {

        log.info("消息被消费"+content);
    }
}
