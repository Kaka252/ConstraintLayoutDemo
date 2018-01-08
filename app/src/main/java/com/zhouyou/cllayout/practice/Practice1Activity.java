package com.zhouyou.cllayout.practice;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.entity.User;
import com.zhouyou.cllayout.practice.adapter.ItemListAdapter;
import com.zhouyou.cllayout.utils.Avatars;
import com.zhouyou.cllayout.utils.UserManager;

import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class Practice1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintlayout_practice_1);
        ListView listView = findViewById(R.id.list_view);

        View banner = LayoutInflater.from(this).inflate(R.layout.view_banner, null);
        SimpleDraweeView ivBanner = banner.findViewById(R.id.iv_banner);
        Uri uri = Uri.parse(Avatars.BANNER);
        ivBanner.setImageURI(uri);
        listView.addHeaderView(banner, null, false);

        List<User> users = UserManager.getUsers();
        ItemListAdapter adapter = new ItemListAdapter(this, users);
        listView.setAdapter(adapter);
    }
}
