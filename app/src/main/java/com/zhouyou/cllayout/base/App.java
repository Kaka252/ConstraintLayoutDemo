package com.zhouyou.cllayout.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
