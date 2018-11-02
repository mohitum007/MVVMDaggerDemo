package com.mohitum.spiceassessment;

import android.app.Application;
import android.content.Context;

import com.mohitum.spiceassessment.dagger.AppComponent;
import com.mohitum.spiceassessment.dagger.DaggerAppComponent;
import com.mohitum.spiceassessment.dagger.AppModule;
import com.mohitum.spiceassessment.dagger.UtilsModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

}
