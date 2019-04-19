package cn.tqktqk.springboot.springbootcache.controller;

import cn.tqktqk.springboot.springbootcache.entity.User;
import cn.tqktqk.springboot.springbootcache.service.UserService;
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
 * @Date: 2019-04-19 14:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public String getInfo(@PathVariable("userId") String userId){
        return userService.getUserInfo(userId);
    }

    @PatchMapping
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @PostMapping
    public void put(@RequestBody User user){
        userService.putUserInfo(user);
    }
}
