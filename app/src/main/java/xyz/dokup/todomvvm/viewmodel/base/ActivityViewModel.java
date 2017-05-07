package xyz.dokup.todomvvm.viewmodel.base;

import android.content.Context;

/**
 * Created by e10dokup on 2017/05/06.
 */

public abstract class ActivityViewModel {

    public abstract void onStart(Context context);

    public abstract void onResume(Context context);

    public abstract void onPause(Context context);

    public abstract void onStop(Context context);
}
