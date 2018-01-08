package com.zhouyou.cllayout.entity;

import java.io.Serializable;

/**
 * Author: ZhouYou
 * Date: 2018/1/4.
 */
public class User implements Serializable {

    public String name;
    public String desc;
    public String avatar;

    public User() {
    }

    public User(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public User(String name, String desc, String avatar) {
        this.name = name;
        this.desc = desc;
        this.avatar = avatar;
    }
}
