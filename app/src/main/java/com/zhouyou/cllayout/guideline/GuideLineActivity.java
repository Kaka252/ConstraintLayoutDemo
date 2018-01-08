package com.zhouyou.cllayout.guideline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.entity.User;
import com.zhouyou.cllayout.utils.UserManager;

import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/8.
 */
public class GuideLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_line);
        ListView listView = findViewById(R.id.list_view);

        List<User> users = UserManager.getUsers();
        GuideLineAdapter adapter = new GuideLineAdapter(this, users);
        listView.setAdapter(adapter);
    }
}
