package xyz.dokup.todomvvm.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import xyz.dokup.todomvvm.entity.Task;

/**
 * Created by e10dokup on 2017/05/06.
 */

public interface TaskLocalDataSource {

    Single<List<Task>> findAll();

    Single<Task> find(@NonNull int id);

    Completable save(@NonNull Task task);

    Single<Integer> update(@NonNull Task task);

    Single<Integer> delete(@NonNull Task task);
}
