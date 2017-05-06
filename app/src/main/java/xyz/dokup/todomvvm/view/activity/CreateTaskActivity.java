package xyz.dokup.todomvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import xyz.dokup.todomvvm.R;
import xyz.dokup.todomvvm.databinding.ActivityMainBinding;
import xyz.dokup.todomvvm.viewmodel.MainActivityViewModel;

public class CreateTaskActivity extends BaseActivity {

    @Inject
    MainActivityViewModel viewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        bindViewModel(viewModel);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }

}
