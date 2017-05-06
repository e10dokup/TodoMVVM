package xyz.dokup.todomvvm.viewmodel;

import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

import javax.inject.Inject;

import timber.log.Timber;
import xyz.dokup.todomvvm.viewmodel.base.ActivityViewModel;

/**
 * Created by e10dokup on 2017/05/06.
 */

public class CreateTaskActivityViewModel extends ActivityViewModel {

    private ObservableField<String> title;
    private ObservableField<String> description;
    private ObservableField<String> deadline;

    private boolean enabled;

    @Inject
    public CreateTaskActivityViewModel() {
        this.title = new ObservableField<>();
        this.description = new ObservableField<>();
        this.deadline = new ObservableField<>();

        enabled = false;
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

    public void onSaveClick(View view) {
        Timber.v("OnSaveClick");

        if (!enabled) {
            Snackbar.make(view, "Fill out all values!", Snackbar.LENGTH_SHORT).show();
        } else {

        }
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Timber.v("Text Changed");

        enabled = !TextUtils.isEmpty(title.get()) && !TextUtils.isEmpty(description.get()) && !TextUtils.isEmpty(deadline.get());
    }

}
