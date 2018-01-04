package com.zhouyou.cllayout.base;

import android.app.Application;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class App extends Application {

    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
    }

    public static App get() {
        return instance;
    }

    /**
     * 屏幕高度
     */
    private int displayHeight;

    public int getDisplayHeight() {
        if (displayHeight == 0) {
            WindowManager mWindowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = mWindowManager.getDefaultDisplay();
            displayHeight = display.getHeight();
        }
        return displayHeight;
    }

    /**
     * 屏幕宽度
     */
    private int displayWidth;

    public int getDisplayWidth() {
        if (displayWidth == 0) {
            WindowManager mWindowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            if (mWindowManager != null) {
                Display display = mWindowManager.getDefaultDisplay();
                displayWidth = display.getWidth();
            }
        }
        return displayWidth;
    }
}
