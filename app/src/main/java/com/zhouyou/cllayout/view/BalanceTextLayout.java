package com.zhouyou.cllayout.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class BalanceTextLayout extends ConstraintLayout {

    public BalanceTextLayout(Context context) {
        this(context, null);
    }

    public BalanceTextLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BalanceTextLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
