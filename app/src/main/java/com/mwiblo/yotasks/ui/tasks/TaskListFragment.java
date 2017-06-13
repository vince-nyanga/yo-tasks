package com.mwiblo.yotasks.ui.tasks;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mwiblo.yotasks.MainActivity;
import com.mwiblo.yotasks.R;
import com.mwiblo.yotasks.YoTasksApp;
import com.mwiblo.yotasks.databinding.ListFragmentBinding;
import com.mwiblo.yotasks.db.entity.Task;
import com.mwiblo.yotasks.viewmodel.TaskListViewModel;
import com.mwiblo.yotasks.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * @author Vincent
 */

public class TaskListFragment extends LifecycleFragment {

    private TasksAdapter tasksAdapter;

    private ListFragmentBinding binding;

    private TaskClickListener listener = new TaskClickListener() {
        @Override
        public void onClick(Task task) {
            // no-op
        }
    };

    private AddTaskCallback callback = new AddTaskCallback() {
        @Override
        public void onClick() {
            ((MainActivity)getActivity()).showAddTaskView();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);
        tasksAdapter = new TasksAdapter(listener);
        binding.tasksList.setAdapter(tasksAdapter);
        binding.setIsListEmpty(tasksAdapter.getItemCount() == 0);
        binding.setCallback(callback);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TaskListViewModel viewModel = ViewModelProviders.of(this, new ViewModelFactory(
                (YoTasksApp)getActivity().getApplication())).get(TaskListViewModel.class);
        viewModel.getTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                tasksAdapter.setTaskList(tasks);
                binding.setIsListEmpty(tasks != null ? tasks.isEmpty(): true);
            }
        });
    }
}
