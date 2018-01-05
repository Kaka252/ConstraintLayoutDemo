package com.zhouyou.cllayout.constraintset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.zhouyou.cllayout.R;

/**
 * Created by zhouyou on 18/1/4.
 */

public class ConstraintSetActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintSet sceneInit = new ConstraintSet();
    ConstraintSet sceneChange = new ConstraintSet();
    ConstraintLayout mConstraintLayout;

    private boolean isChanged;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_set);
        mConstraintLayout = findViewById(R.id.constraintLayout);
        sceneInit.clone(mConstraintLayout);
        sceneChange.clone(mConstraintLayout);


        findViewById(R.id.iv_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_image:
                if (isChanged) {
                    transitionTo(sceneInit);
                } else {
                    transitionTo(sceneChange);
                }
                isChanged = !isChanged;
                break;
            default:
                break;
        }
    }

    private void transitionTo(ConstraintSet constraintSet) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        if (!isChanged) {
            constraintSet.constrainWidth(R.id.iv_image, ConstraintSet.WRAP_CONTENT);
            constraintSet.centerHorizontally(R.id.iv_image, R.id.constraintLayout);
            constraintSet.centerVertically(R.id.iv_image, R.id.constraintLayout);
            constraintSet.setVisibility(R.id.btn_click, ConstraintSet.VISIBLE);
        }
        constraintSet.applyTo(mConstraintLayout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isChanged) {
                transitionTo(sceneInit);
                isChanged = !isChanged;
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
