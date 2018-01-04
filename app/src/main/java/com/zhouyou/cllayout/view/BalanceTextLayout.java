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

    public void calculate() {
        int w = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.AT_MOST);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        this.measure(w, h);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();


        int wholeTextLength = 0;
        int viewCount = getChildCount();
        for (int i = 0; i < viewCount; i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TextPaint textPaint = textView.getPaint();
                float textLength = textPaint.measureText(textView.getText().toString().trim());
                wholeTextLength += textLength;
                Log.d("BalanceTextLayout", "child_" + i + " = " + textLength);
            }
        }

        View view = getChildAt(0);
        if (view == null) {
            return;
        }
        ConstraintLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        if (width >= wholeTextLength) {
            params.width = LayoutParams.MATCH_CONSTRAINT_WRAP;
            params.horizontalBias = 0f;
            params.horizontalChainStyle = LayoutParams.CHAIN_PACKED;
        } else {
            params.width = 0;
            params.horizontalBias = 0f;
            params.horizontalChainStyle = LayoutParams.CHAIN_SPREAD;
        }
        view.setLayoutParams(params);
    }
}
