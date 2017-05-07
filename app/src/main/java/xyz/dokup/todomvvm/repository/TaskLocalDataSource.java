package xyz.dokup.todomvvm.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.dokup.todomvvm.model.OrmaDatabase;
import xyz.dokup.todomvvm.model.Task;

/**
 * Created by e10dokup on 2017/05/07.
 */

public class TaskLocalDataSource {

    private final OrmaDatabase ormaDatabase;

    @Inject
    public TaskLocalDataSource(OrmaDatabase ormaDatabase) {
        this.ormaDatabase = ormaDatabase;
    }

    public Single<List<Task>> findAll() {
        return ormaDatabase.relationOfTask()
                .selector()
                .executeAsObservable()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

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

    public Completable save(@NonNull Task task) {
        return ormaDatabase.transactionAsCompletable(() -> ormaDatabase.relationOfTask().inserter().execute(task))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

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

    public Single<Integer> delete(@NonNull Task task) {
        return ormaDatabase.relationOfTask()
                .deleter()
                .idEq(task.id)
                .executeAsSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
