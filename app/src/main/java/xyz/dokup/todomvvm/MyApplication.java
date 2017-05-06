package xyz.dokup.todomvvm;

import android.app.Application;

import timber.log.Timber;
import xyz.dokup.todomvvm.di.AppComponent;
import xyz.dokup.todomvvm.di.AppModule;
import xyz.dokup.todomvvm.di.DaggerAppComponent;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class MyApplication extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

        Timber.plant(new Timber.DebugTree());
    }
}
