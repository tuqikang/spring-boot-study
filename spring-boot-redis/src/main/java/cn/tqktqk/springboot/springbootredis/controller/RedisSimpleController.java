package cn.tqktqk.springboot.springbootredis.controller;

import cn.tqktqk.springboot.springbootredis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-17 15:10
 */
@RestController
@RequestMapping("/redis")
public class RedisSimpleController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @GetMapping
    public String count(){
        if (!stringRedisTemplate.hasKey("count")){
            //向redis中设置key value
            stringRedisTemplate.opsForValue().set("count","1");
            return "网页浏览总量：1";
        }
        //给对应key的value进行加1操作,decrement是减一操作，里面可以填具体值num，指增加/减少num
        stringRedisTemplate.boundValueOps("count").increment();//val +1
        return "网页浏览总量："+stringRedisTemplate.opsForValue().get("count");
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        redisTemplate.opsForValue().set(user.getName(),user);
    }

    @GetMapping("/{name}")
    public String saveUser(@PathVariable String name){
        return ((User)redisTemplate.opsForValue().get(name)).toString();
    }
}
