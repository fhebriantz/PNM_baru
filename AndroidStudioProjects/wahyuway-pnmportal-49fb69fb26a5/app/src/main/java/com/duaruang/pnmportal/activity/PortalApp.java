package com.duaruang.pnmportal.activity;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mikepenz.iconics.context.IconicsContextWrapper;

public class PortalApp extends Application{
    private static PortalApp singleton = new PortalApp();

    static PortalApp getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (!Fresco.hasBeenInitialized())
            Fresco.initialize(this);
        singleton = this;
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
//    }
}
