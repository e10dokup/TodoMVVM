package xyz.dokup.todomvvm.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import timber.log.Timber;
import xyz.dokup.todomvvm.model.Task;
import xyz.dokup.todomvvm.util.TaskUtil;
import xyz.dokup.todomvvm.view.helper.Navigator;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class TaskViewModel {

    private final Navigator navigator;

    public ObservableField<Task> task;
    public ObservableField<String> deadline;

    public TaskViewModel(Navigator navigator, ObservableField<Task> task) {
        this.navigator = navigator;
        this.task = task;
        deadline = new ObservableField<>();
        deadline.set(TaskUtil.decodeDeadline(task.get().deadlineEpoch));
    }

    public ObservableField<Task> getTask() {
        return task;
    }

    public void setTask(ObservableField<Task> task) {
        this.task = task;
        deadline.set(TaskUtil.decodeDeadline(task.get().deadlineEpoch));
    }

    public void onItemClick(View view) {
        Timber.v("onClick");
        navigator.navigateToTaskDetail(task.get().id);
    }
}
