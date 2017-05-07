package xyz.dokup.todomvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import xyz.dokup.todomvvm.R;
import xyz.dokup.todomvvm.databinding.ActivityDetailTaskBinding;
import xyz.dokup.todomvvm.viewmodel.TaskDetailActivityViewModel;

public class TaskDetailActivity extends BaseActivity {
    private static final String TASK_ID = "task_id";

    @Inject
    TaskDetailActivityViewModel viewModel;

    private ActivityDetailTaskBinding binding;

    public static Intent createIntent(Context context, int id) {
        Intent intent = new Intent(context, TaskDetailActivity.class);
        intent.putExtra(TASK_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        bindViewModel(viewModel);

        viewModel.setTaskId(getIntent().getIntExtra(TASK_ID, 0));

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_task);
        binding.setViewModel(viewModel);

        initBackToolbar(binding.toolbar);
    }

}
