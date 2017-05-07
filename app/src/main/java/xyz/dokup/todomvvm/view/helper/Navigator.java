package xyz.dokup.todomvvm.view.helper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import xyz.dokup.todomvvm.di.scope.ActivityScope;
import xyz.dokup.todomvvm.view.activity.CreateTaskActivity;

/**
 * Created by e10dokup on 2017/05/07.
 */
@ActivityScope
public class Navigator {

    private final Activity activity;

    @Inject
    public Navigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void navigateToCreateTask() {
        activity.startActivity(CreateTaskActivity.createIntent(activity));
    }

    public void closeActivity() {
        activity.finish();
    }


}
