package xyz.dokup.todomvvm.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e10dokup on 2017/05/06.
 */
@Module
public class FragmentModule {

    final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return fragment.getFragmentManager();
    }
}
