package xyz.dokup.todomvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import javax.inject.Inject;

import xyz.dokup.todomvvm.R;
import xyz.dokup.todomvvm.databinding.ActivityMainBinding;
import xyz.dokup.todomvvm.databinding.ItemTaskBinding;
import xyz.dokup.todomvvm.view.adapter.BindingHolder;
import xyz.dokup.todomvvm.view.adapter.ObservableListRecyclerAdapter;
import xyz.dokup.todomvvm.view.adapter.itemdecoration.DividerItemDecoration;
import xyz.dokup.todomvvm.viewmodel.MainActivityViewModel;
import xyz.dokup.todomvvm.viewmodel.TaskViewModel;

public class MainActivity extends BaseActivity {

    @Inject
    MainActivityViewModel viewModel;

    private ActivityMainBinding binding;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        bindViewModel(viewModel);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel.start(this);
    }

    private void initRecyclerView() {
        TaskAdapter adapter = new TaskAdapter(this, viewModel.getTaskViewModels());
        binding.taskRecycler.setAdapter(adapter);
        binding.taskRecycler.setHasFixedSize(true);
        binding.taskRecycler.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));
        binding.taskRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private class TaskAdapter extends ObservableListRecyclerAdapter<TaskViewModel, BindingHolder<ItemTaskBinding>> {

        public TaskAdapter(Context context, ObservableList<TaskViewModel>list) {
            super(context, list);
        }

        @Override
        public BindingHolder<ItemTaskBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BindingHolder<>(getContext(), parent, R.layout.item_task);
        }

        @Override
        public void onBindViewHolder(BindingHolder<ItemTaskBinding> holder, int position) {
            TaskViewModel viewModel = getItem(position);
            ItemTaskBinding binding = holder.binding;
            binding.setViewModel(viewModel);
        }

        @Override
        public long getItemId(int position) {
            TaskViewModel viewModel = getItem(position);
            return viewModel.task.get().id;
        }
    }

}
