package xyz.dokup.todomvvm.di;

import dagger.Subcomponent;
import xyz.dokup.todomvvm.di.scope.FragmentScope;

/**
 * Created by e10dokup on 2017/05/06.
 */
@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

//    void inject(MainFragment fragment);
}
