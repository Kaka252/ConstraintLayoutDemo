package com.zhouyou.cllayout.utils;

import com.zhouyou.cllayout.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/4.
 */
public class UserManager {

    private static final String[] AVATARS = {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514973958416&di=ef4f1911952dac43d7f1bcd72a7ca432&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D8a7b8145c1fdfc03e52debbce10faba2%2Fb8389b504fc2d562c7b2a756e51190ef77c66cd6.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514974151513&di=8a1a34524abf1eb6d32da523cafe4cc0&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D2512697277%2C979751724%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514974162186&di=df01de6bb1366f660a0a0427e5f077f1&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1271743714%2C847290664%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514973958414&di=bea99856884ed1851694260f1bcdfb2d&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fwh%253D600%252C800%2Fsign%3D9b8620737dd98d1076810437110f9436%2Fb3fb43166d224f4a95ffc59c08f790529922d1df.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514974196690&di=095f7afe549ab3d13eda872f184add74&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1889530518%2C1090420221%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514973958408&di=a9718fd7fe4a0cb9e41ca43f75c06fa3&imgtype=0&src=http%3A%2F%2Fimg.bitscn.com%2Fupimg%2Fallimg%2Fc160120%2F1453262P045310-29236.jpg"
    };

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("郭峰", "Android研发", AVATARS[0]));
        users.add(new User("王大田", "PHP开发", AVATARS[1]));
        users.add(new User("特别特别特别特别特特别长的名字", "CEO", AVATARS[2]));
        users.add(new User("特别特别长的名字", "产品经理", AVATARS[3]));
        users.add(new User("俞老师", "Android研发", AVATARS[4]));
        users.add(new User("三BB", "Delphi开发", AVATARS[5]));
        return users;
    }
}
