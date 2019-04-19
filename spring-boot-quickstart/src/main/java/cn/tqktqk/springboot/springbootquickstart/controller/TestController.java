package cn.tqktqk.springboot.springbootquickstart.controller;

import cn.tqktqk.springboot.springbootquickstart.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-19 15:28
 */
@RestController
@RequestMapping("/info")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping
    public Map<String,String> getInfo(){
        return userMapper.getInfo();
    }
}
