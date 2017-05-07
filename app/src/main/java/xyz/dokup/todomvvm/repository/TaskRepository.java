package xyz.dokup.todomvvm.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;
import xyz.dokup.todomvvm.model.Task;

/**
 * Created by e10dokup on 2017/05/06.
 */
@Singleton
public class TaskRepository {

    private final TaskLocalDataSource taskLocalDataSource;

    @Inject
    public TaskRepository(TaskLocalDataSource taskLocalDataSource) {
        this.taskLocalDataSource = taskLocalDataSource;
    }

    public Single<List<Task>> findAll() {
        return taskLocalDataSource.findAll();
    }

    public Single<Task> find(@NonNull int id) {
        return taskLocalDataSource.find(id);
    }

    public Completable save(@NonNull Task task) {
        return taskLocalDataSource.save(task);
    }

    public Single<Integer> update(@NonNull Task task) {
        return taskLocalDataSource.update(task);
    }

    public Single<Integer> delete(@NonNull Task task) {
        return taskLocalDataSource.delete(task);
    }
}
