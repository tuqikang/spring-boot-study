package cn.tqktqk.springboot.springbootrabbitmq.controller;

import cn.tqktqk.springboot.springbootrabbitmq.model.UserInfo;
import cn.tqktqk.springboot.springbootrabbitmq.service.HelloSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-16 16:00
 */
@RestController
@RequestMapping("/hello")
public class HelloTestContorller {

    @Autowired
    private HelloSenderService senderService;

    @PostMapping
    public void send(@RequestBody UserInfo userInfo){
        senderService.send(userInfo);
    }

    @GetMapping
    public void initTest(){
        senderService.send1();
        senderService.send2();
    }
}
