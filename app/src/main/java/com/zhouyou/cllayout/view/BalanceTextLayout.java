package com.zhouyou.cllayout.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

    public void calculate(int width) {
        int wholeTextLength = 0;
        int viewCount = getChildCount();

        int tailLength = 0;


        for (int i = 0; i < viewCount; i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TextPaint textPaint = textView.getPaint();
                float textLength = textPaint.measureText(textView.getText().toString().trim());
                wholeTextLength += textLength;
                Log.d("BalanceTextLayout", "child_" + i + " = " + textLength);
                if (i > 0) {
                    tailLength += textLength;
                }
            }
        }

        View view = getChildAt(0);
        if (view == null) {
            return;
        }
        ConstraintLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        if (width >= wholeTextLength) {
            params.width = LayoutParams.WRAP_CONTENT;
            params.horizontalChainStyle = LayoutParams.CHAIN_PACKED;
        } else {
            int widgetLength = width - tailLength;
            params.width = widgetLength > 0 ? widgetLength : 0;
            params.horizontalChainStyle = LayoutParams.CHAIN_SPREAD_INSIDE;
        }
        view.setLayoutParams(params);
    }
}
