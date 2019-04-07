package cn.tqktqk.spring.springbootmongodb.service;

import cn.tqktqk.spring.springbootmongodb.dao.UsersRepository;
import cn.tqktqk.spring.springbootmongodb.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-07 21:34
 */
@Service
public class UsersMongoService {

    @Autowired
    private UsersRepository usersRepository;

    /**
     * 查询所有信息
     * @return
     */
    public String getUsers(int pn,int size){
        PageRequest pageRequest = PageRequest.of(pn-1,size);
        StringBuilder builder = new StringBuilder();
        Sort sort=new Sort(Sort.Direction.ASC,"age");
        Page<Users> page = usersRepository.findAll(pageRequest);
        page.getContent().stream().forEach(p->{
            builder.append(p.toString()+"\n");
        });
        return builder.toString();
    }

    /**
     * 按id查询
     */
    public String getUser(String id){
        return usersRepository.findById(id).toString();
    }

    public String getUserByName(String name) {
        return usersRepository.findByName(name).toString();
    }
}
