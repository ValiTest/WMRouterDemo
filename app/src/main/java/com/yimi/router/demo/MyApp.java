package com.yimi.router.demo;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Utils.initRouter(context, BuildConfig.DEBUG);
    }

}
