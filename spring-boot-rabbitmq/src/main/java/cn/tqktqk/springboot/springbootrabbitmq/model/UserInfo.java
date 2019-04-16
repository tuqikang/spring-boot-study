package cn.tqktqk.springboot.springbootrabbitmq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-16 16:09
 */
@Data
public class UserInfo implements Serializable {

    private static final long SerializableUID=-2131241L;

    private String username;

    private String address;

    private String job;

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
