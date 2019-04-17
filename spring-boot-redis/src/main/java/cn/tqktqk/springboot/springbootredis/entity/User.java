package cn.tqktqk.springboot.springbootredis.entity;

import lombok.Data;
import sun.rmi.runtime.Log;

import java.io.Serializable;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-17 15:23
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6159816003029146526L;

    private String name;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
