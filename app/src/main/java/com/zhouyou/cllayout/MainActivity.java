package com.zhouyou.cllayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhouyou.cllayout.bias.BiasActivity;
import com.zhouyou.cllayout.chain.ChainActivity;
import com.zhouyou.cllayout.constraintset.ConstraintSetActivity;
import com.zhouyou.cllayout.positioning.PositioningRelativeActivity;
import com.zhouyou.cllayout.positioning.PositioningViewActivity;
import com.zhouyou.cllayout.practice.Practice1Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_view_positioning).setOnClickListener(this);
        findViewById(R.id.btn_relative_positioning).setOnClickListener(this);
        findViewById(R.id.btn_bias).setOnClickListener(this);
        findViewById(R.id.btn_chain).setOnClickListener(this);
        findViewById(R.id.btn_practise_1).setOnClickListener(this);
        findViewById(R.id.btn_constraint_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_view_positioning:
                intent = new Intent(this, PositioningViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_relative_positioning:
                intent = new Intent(this, PositioningRelativeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_bias:
                intent = new Intent(this, BiasActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_chain:
                intent = new Intent(this, ChainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_practise_1:
                intent = new Intent(this, Practice1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_constraint_set:
                intent = new Intent(this, ConstraintSetActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
