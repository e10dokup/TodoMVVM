package xyz.dokup.todomvvm.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e10dokup on 2017/05/06.
 */
@Module
public class ActivityModule {

    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public AppCompatActivity provideActivity() {
        return activity;
    }
}
