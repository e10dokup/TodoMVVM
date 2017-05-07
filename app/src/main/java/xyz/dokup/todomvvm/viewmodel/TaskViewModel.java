package xyz.dokup.todomvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import timber.log.Timber;
import xyz.dokup.todomvvm.model.Task;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class TaskViewModel {



    public ObservableField<Task> task;
    public ObservableField<String> deadline;

    public TaskViewModel(Context context, ObservableField<Task> task) {
        this.task = task;
        deadline = new ObservableField<>();
        deadline.set("hoge");
    }

    public ObservableField<Task> getTask() {
        return task;
    }

    public void setTask(ObservableField<Task> task) {
        this.task = task;
        deadline.set("hoge");
    }

    public void onItemClick(View view) {
        Timber.v("onClick");

    }
}
