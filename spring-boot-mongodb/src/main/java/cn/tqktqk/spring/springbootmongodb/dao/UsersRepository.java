package cn.tqktqk.spring.springbootmongodb.dao;

import cn.tqktqk.spring.springbootmongodb.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-07 21:33
 */
public interface UsersRepository extends MongoRepository<Users,String> {
    Users findByName(String name);
}
