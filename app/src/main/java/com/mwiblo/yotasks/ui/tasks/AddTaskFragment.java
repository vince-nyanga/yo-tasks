package com.mwiblo.yotasks.ui.tasks;

import android.app.Dialog;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mwiblo.yotasks.R;
import com.mwiblo.yotasks.YoTasksApp;
import com.mwiblo.yotasks.databinding.AddTaskFragmentBinding;
import com.mwiblo.yotasks.viewmodel.TaskListViewModel;
import com.mwiblo.yotasks.viewmodel.ViewModelFactory;

/**
 * @author Vincent
 */

public class AddTaskFragment extends DialogFragment  {


    TaskListViewModel viewModel;

    AddTaskFragmentBinding binding;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.add_task_fragment,
                null, false);
        viewModel = ViewModelProviders.of(this, new ViewModelFactory(
                (YoTasksApp)getActivity().getApplication())).get(TaskListViewModel.class);
        return new AlertDialog.Builder(getActivity())
                .setTitle("Add task")
                .setView(binding.getRoot())
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      addTask();
                    }
                }).show();
    }

    private void addTask() {
        String name = binding.taskName.getText().toString();
        if(!TextUtils.isEmpty(name)){
            viewModel.addTask(name);
        }
    }


}
