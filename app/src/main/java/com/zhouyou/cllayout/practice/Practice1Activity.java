package com.zhouyou.cllayout.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.practice.adapter.ItemListAdapter;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class Practice1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrainlayout_practice_1);
        ListView listView = findViewById(R.id.list_view);

        ItemListAdapter adapter = new ItemListAdapter(this);
        listView.setAdapter(adapter);
    }
}
