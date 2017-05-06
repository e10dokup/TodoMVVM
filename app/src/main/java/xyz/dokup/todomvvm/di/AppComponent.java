package xyz.dokup.todomvvm.di;

import javax.inject.Singleton;

import dagger.Component;
import xyz.dokup.todomvvm.MyApplication;

/**
 * Created by e10dokup on 2017/05/06.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MyApplication application);

    ActivityComponent plus(ActivityModule module);
}
