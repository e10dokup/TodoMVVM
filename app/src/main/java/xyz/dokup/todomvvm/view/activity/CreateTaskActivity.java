package xyz.dokup.todomvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import xyz.dokup.todomvvm.R;
import xyz.dokup.todomvvm.databinding.ActivityCreateTaskBinding;
import xyz.dokup.todomvvm.viewmodel.CreateTaskActivityViewModel;

public class CreateTaskActivity extends BaseActivity {

    @Inject
    CreateTaskActivityViewModel viewModel;

    private ActivityCreateTaskBinding binding;

    public static Intent createIntent(Context context) {
        return new Intent(context, CreateTaskActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        bindViewModel(viewModel);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_task);
        binding.setViewModel(viewModel);

        initBackToolbar(binding.toolbar);
    }

}
