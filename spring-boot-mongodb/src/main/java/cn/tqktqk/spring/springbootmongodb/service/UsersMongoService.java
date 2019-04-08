package cn.tqktqk.spring.springbootmongodb.service;

import cn.tqktqk.spring.springbootmongodb.dao.UsersRepository;
import cn.tqktqk.spring.springbootmongodb.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    private Logger logger = LoggerFactory.getLogger(UsersMongoService.class);

    @Autowired
    private UsersRepository usersRepository;

    /**
     * 查询所有信息
     * @return
     */
    public String getUsers(int pn,int size){
        /**
         * 进行分页
         */
        PageRequest pageRequest = PageRequest.of(pn-1,size);
        StringBuilder builder = new StringBuilder();
//        Sort sort=new Sort(Sort.Direction.ASC,"age");
        /**
         * 得到分页查询结果
         */
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

    /**
     * 按照name查询
     * @param name
     * @return
     */
    public String getUserByName(String name) {
        return usersRepository.findByName(name).toString();
    }

    /**
     * 修改操作
     * @param users
     */
    public void saveUser(Users users){
        if(usersRepository.save(users)!=null){
            logger.info("保存成功");
        }else
            logger.info("修改失败，未找到该条信息");
    }

    /**
     * 通过id删除
     * @param id
     */
    public void delete(String id){
        usersRepository.deleteById(id);
    }

}
