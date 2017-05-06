package xyz.dokup.todomvvm.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import javax.inject.Inject;

import timber.log.Timber;
import xyz.dokup.todomvvm.viewmodel.base.ActivityViewModel;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class MainActivityViewModel extends ActivityViewModel {

    private ObservableList<TaskViewModel> taskViewModels;

    @Inject
    public MainActivityViewModel() {
        this.taskViewModels = new ObservableArrayList<>();
    }

    public ObservableList<TaskViewModel> getTaskViewModels() {
        return taskViewModels;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    public void onFabClick(View view) {
        Timber.v("OnClickFab");
    }

}
