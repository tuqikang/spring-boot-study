package cn.tqktqk.spring.springbootmongodb.controller;

import cn.tqktqk.spring.springbootmongodb.model.Users;
import cn.tqktqk.spring.springbootmongodb.service.UsersMongoService;
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
 * @Date: 2019-04-07 21:38
 */
@RestController
@RequestMapping("/mongo")
public class MongodbController {

    @Autowired
    private UsersMongoService usersMongoService;

    @GetMapping
    public String users(@RequestParam(value = "pn",defaultValue = "1") int pn,@RequestParam(value = "size",defaultValue = "5") int size){
        return usersMongoService.getUsers(pn,size);
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable String id){
        return usersMongoService.getUser(id);
    }

    @GetMapping("/by/{name}")
    public String userByName(@PathVariable String name){
        return usersMongoService.getUserByName(name);
    }

    @PatchMapping
    public void saveUser(@RequestBody Users users){
        usersMongoService.saveUser(users);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        usersMongoService.delete(id);
    }
}
