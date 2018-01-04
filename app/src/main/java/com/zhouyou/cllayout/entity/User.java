package com.zhouyou.cllayout.entity;

import java.io.Serializable;

/**
 * Author: ZhouYou
 * Date: 2018/1/4.
 */
public class User implements Serializable {

    public String name;
    public String avatar;

    public User(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }
}
