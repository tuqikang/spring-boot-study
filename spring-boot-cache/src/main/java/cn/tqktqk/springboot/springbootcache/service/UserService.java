package cn.tqktqk.springboot.springbootcache.service;

import cn.tqktqk.springboot.springbootcache.dao.UserMapper;
import cn.tqktqk.springboot.springbootcache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-19 14:36
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(cacheNames = "user_info",key = "#userId")
    public String getUserInfo(String userId){
        String info= userMapper.getUserById(userId).toString();
        return info;
    }

    /**
     * allEntries 是否将cacheNames下的缓存全部清理
     * beforeInvocation 是否在方法执行前就进行清理缓存
     * @param user
     */
    @CacheEvict(cacheNames = "user_info",key = "#user.userId",allEntries=true,beforeInvocation = true)
    public void update(User user){
        userMapper.updateUserInfo(user);
    }

    @CachePut(cacheNames = "user_info",key = "#user.userId")
    public String putUserInfo(User user){
        return user.toString();
    }
}
