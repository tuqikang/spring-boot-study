package cn.tqktqk.springboot.springbootmail.config;

import cn.tqktqk.springboot.springbootmail.service.DefaultMailTemplate;
import cn.tqktqk.springboot.springbootmail.service.IMailTemplate;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-17 12:46
 */
@SpringBootConfiguration
public class MailConfig {

    @Bean
    @ConditionalOnMissingBean(IMailTemplate.class)
    public IMailTemplate mailTemplate(){
        return new DefaultMailTemplate();
    }
}
