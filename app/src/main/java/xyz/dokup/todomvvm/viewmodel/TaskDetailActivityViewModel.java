package xyz.dokup.todomvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.view.View;

import javax.inject.Inject;

import xyz.dokup.todomvvm.model.Task;
import xyz.dokup.todomvvm.repository.TaskRepository;
import xyz.dokup.todomvvm.util.TaskUtil;
import xyz.dokup.todomvvm.view.helper.Navigator;
import xyz.dokup.todomvvm.viewmodel.base.ActivityViewModel;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class TaskDetailActivityViewModel extends ActivityViewModel {

    private final Navigator navigator;
    private final TaskRepository taskRepository;

    public ObservableField<Task> task;
    public ObservableField<String> deadline;

    private int taskId;

    @Inject
    public TaskDetailActivityViewModel(Navigator navigator, TaskRepository taskRepository) {
        this.navigator = navigator;
        this.taskRepository = taskRepository;

        this.task = new ObservableField<>();
        this.deadline = new ObservableField<>();
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void onStart(Context context) {

    }

    @Override
    public void onResume(Context context) {
        taskRepository.find(taskId)
                .subscribe(task1 -> {
                    task.set(task1);
                    deadline.set(TaskUtil.decodeDeadline(task1.deadlineEpoch));
                });
    }

    @Override
    public void onPause(Context context) {

    }

    @Override
    public void onStop(Context context) {

    }

    public void onDeleteClick(View view) {
        taskRepository.delete(task.get())
                .subscribe(integer -> {
                    Snackbar.make(view, "Delete task succeed", Snackbar.LENGTH_SHORT).show();
                    navigator.closeActivity();
                });
    }
}
