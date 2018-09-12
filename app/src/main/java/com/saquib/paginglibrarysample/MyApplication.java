package com.saquib.paginglibrarysample;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.saquib.paginglibrarysample.di.AppComponent;
import com.saquib.paginglibrarysample.di.DaggerAppComponent;
import com.saquib.paginglibrarysample.di.UtilsModule;


/**
 * Created by ${Saquib} on 12-08-2018.
 */

public class MyApplication extends Application {
    AppComponent appComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().utilsModule(new UtilsModule()).build();
        Fresco.initialize(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }
}
