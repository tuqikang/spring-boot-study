package cn.tqktqk.springboot.springbootrabbitmq.controller;

import cn.tqktqk.springboot.springbootrabbitmq.service.HelloSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void send(){
        senderService.send();
    }
}
