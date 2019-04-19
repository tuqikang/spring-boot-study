package cn.tqktqk.springboot.springbootquickstart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-19 15:25
 */
public class UserMapper {

    public Map<String,String> getInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("name","小白");
        map.put("age","20");
        map.put("address","北京");
        return map;
    }
}
