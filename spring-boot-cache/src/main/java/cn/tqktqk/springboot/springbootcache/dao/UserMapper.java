package cn.tqktqk.springboot.springbootcache.dao;

import cn.tqktqk.springboot.springbootcache.entity.User;

import java.util.concurrent.TimeUnit;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-19 14:31
 */
public class UserMapper {

    public User getUserById(String userId){
        System.out.println("查询中.....");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user=new User();
        user.setAddress("成都");
        user.setUserId(userId);
        user.setName("小明");
        return user;
    }

    public void updateUserInfo(User user){

    }
}
