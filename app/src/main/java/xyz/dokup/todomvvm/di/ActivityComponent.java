package xyz.dokup.todomvvm.di;

import dagger.Subcomponent;
import xyz.dokup.todomvvm.di.scope.ActivityScope;
import xyz.dokup.todomvvm.view.activity.CreateTaskActivity;
import xyz.dokup.todomvvm.view.activity.MainActivity;

/**
 * Created by e10dokup on 2017/05/06.
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(CreateTaskActivity activity);

    FragmentComponent plus(FragmentModule module);
}
