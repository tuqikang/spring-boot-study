package cn.tqktqk.springboot.springbootquickstart.config;

import cn.tqktqk.springboot.springbootquickstart.dao.UserMapper;
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
 * @Date: 2019-04-19 15:27
 */
@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
}
