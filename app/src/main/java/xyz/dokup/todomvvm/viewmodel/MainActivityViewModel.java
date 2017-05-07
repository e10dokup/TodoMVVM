package xyz.dokup.todomvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.view.View;

import com.annimon.stream.Stream;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;
import xyz.dokup.todomvvm.entity.Task;
import xyz.dokup.todomvvm.repository.TaskRepository;
import xyz.dokup.todomvvm.view.helper.Navigator;
import xyz.dokup.todomvvm.viewmodel.base.ActivityViewModel;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class MainActivityViewModel extends ActivityViewModel {

    private final Navigator navigator;
    private final TaskRepository taskRepository;

    private ObservableList<TaskViewModel> taskViewModels;


    @Inject
    public MainActivityViewModel(Navigator navigator, TaskRepository taskRepository) {
        this.navigator = navigator;
        this.taskRepository = taskRepository;

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
        navigator.navigateToCreateTask();
    }

    public void start(Context context) {
        taskRepository.findAll()
                .map(tasks -> Stream.of(tasks)
                        .sorted((o1, o2) -> (int)(o1.deadlineEpoch - o2.deadlineEpoch))
                        .toList())
                .map(tasks -> convertToViewModel(context, tasks))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(taskViewModels1 -> {
                    this.taskViewModels.clear();
                    this.taskViewModels.addAll(taskViewModels1);
                });
    }

    private List<TaskViewModel> convertToViewModel(Context context, List<Task> tasks) {
        return Stream.of(tasks).map(task -> new TaskViewModel(context, navigator, new ObservableField<>(task))).toList();
    }

}
