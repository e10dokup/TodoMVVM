package xyz.dokup.todomvvm.di;

import dagger.Subcomponent;
import xyz.dokup.todomvvm.di.scope.ActivityScope;

/**
 * Created by e10dokup on 2017/05/06.
 */
@ActivityScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(MainFragment fragment);
}
