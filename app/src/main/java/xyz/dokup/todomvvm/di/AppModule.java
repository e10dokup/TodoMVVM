package xyz.dokup.todomvvm.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e10dokup on 2017/05/06.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

//    @Singleton
//    @Provides
//    public OrmaDatabase provideOrmaDatabase(Context context) {
//        return OrmaDatabase.builder(context).build();
//    }
}
