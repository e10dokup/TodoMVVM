package xyz.dokup.todomvvm.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.dokup.todomvvm.datasource.TaskLocalDataSource;
import xyz.dokup.todomvvm.entity.OrmaDatabase;
import xyz.dokup.todomvvm.entity.Task;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class TaskRepository implements TaskLocalDataSource {

    private final OrmaDatabase ormaDatabase;

    @Inject
    public TaskRepository(OrmaDatabase ormaDatabase) {
        this.ormaDatabase = ormaDatabase;
    }

    @Override
    public Single<List<Task>> findAll() {
        return ormaDatabase.relationOfTask()
                .selector()
                .executeAsObservable()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<Task> find(@NonNull int id) {
        return ormaDatabase.relationOfTask()
                .selector()
                .idEq(id)
                .limit(1)
                .executeAsObservable()
                .firstOrError()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable save(@NonNull Task task) {
        return ormaDatabase.transactionAsCompletable(() -> ormaDatabase.relationOfTask().inserter().execute(task))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<Integer> update(@NonNull Task task) {
        return ormaDatabase.relationOfTask()
                .updater()
                .idEq(task.id)
                .title(task.title)
                .description(task.description)
                .deadlineEpoch(task.deadlineEpoch)
                .executeAsSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<Integer> delete(@NonNull Task task) {
        return ormaDatabase.relationOfTask()
                .deleter()
                .idEq(task.id)
                .executeAsSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
