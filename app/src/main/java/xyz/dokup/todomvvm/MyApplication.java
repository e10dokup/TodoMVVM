package xyz.dokup.todomvvm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.jakewharton.threetenabp.AndroidThreeTen;

import timber.log.Timber;
import xyz.dokup.todomvvm.di.AppComponent;
import xyz.dokup.todomvvm.di.AppModule;
import xyz.dokup.todomvvm.di.DaggerAppComponent;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class MyApplication extends Application {

    AppComponent component;

    @NonNull
    public AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

        AndroidThreeTen.init(this);

        Timber.plant(new Timber.DebugTree());
    }
}
