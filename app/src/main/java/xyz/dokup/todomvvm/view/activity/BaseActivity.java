package xyz.dokup.todomvvm.view.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import xyz.dokup.todomvvm.MyApplication;
import xyz.dokup.todomvvm.di.ActivityComponent;
import xyz.dokup.todomvvm.di.ActivityModule;
import xyz.dokup.todomvvm.viewmodel.base.ActivityViewModel;

/**
 * Created by e10dokup on 2017/05/06.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent component;
    private ActivityViewModel viewModel;

    @NonNull
    public ActivityComponent getComponent() {
        if (component == null) {
            MyApplication application = (MyApplication) getApplication();
            component = application.getComponent().plus(new ActivityModule(this));
        }
        return component;
    }

    protected void bindViewModel(ActivityViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkViewModel();
        viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkViewModel();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        checkViewModel();
        viewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        checkViewModel();
        viewModel.onStop();
    }

    private void checkViewModel() {
        if (viewModel == null) {
            throw new IllegalStateException("Before resuming activity, bindViewModel must be called.");
        }
    }
}
