package com.zhouyou.cllayout.constraintset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhouyou.cllayout.R;

/**
 * Created by zhouyou on 18/1/4.
 */

public class ConstraintSetActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintSet mSceneOne = new ConstraintSet();
    ConstraintSet mSceneTwo = new ConstraintSet();
    ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_transition_1);
        mSceneOne.clone(this, R.layout.view_transition_1);
        mSceneTwo.clone(this, R.layout.view_transition_2);

        mConstraintLayout = findViewById(R.id.constraintLayout);
        findViewById(R.id.button_next).setOnClickListener(this);
        findViewById(R.id.button_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_next:
                transitionTo(mSceneTwo);
                break;
            case R.id.button_cancel:
                transitionTo(mSceneOne);
                break;
            default:
                // Do nothing
                break;
        }
    }

    private void transitionTo(ConstraintSet constraintSet) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        constraintSet.applyTo(mConstraintLayout);
    }
}
