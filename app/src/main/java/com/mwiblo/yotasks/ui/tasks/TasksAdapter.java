package com.mwiblo.yotasks.ui.tasks;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mwiblo.yotasks.R;
import com.mwiblo.yotasks.databinding.TaskItemBinding;
import com.mwiblo.yotasks.db.entity.Task;

import java.util.List;

import javax.annotation.Nullable;

/**
 * @author Vincent
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskHolder> {

    private List<Task> list;

    @Nullable
    private TaskClickListener clickListener;

    public TasksAdapter(TaskClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup container, int i) {
        TaskItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(container
                .getContext()), R.layout.task_item,container, false);
        binding.setCallback(clickListener);

        return new TaskHolder(binding);
    }

    @Override
    public void onBindViewHolder(TaskHolder taskHolder, int position) {
        taskHolder.binding.setTask(list.get(position));
        taskHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list ==null ? 0 : list.size();
    }

    public void setTaskList(final List<Task> newList){
        if(this.list == null){
            this.list = newList;
        }else{
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return list.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldPosition, int newPosition) {
                     return list.get(oldPosition).getId() == newList.get(newPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldPosition, int newPosition) {
                    return list.get(oldPosition).getId() == newList.get(newPosition).getId();
                }
            });
            list = newList;
            result.dispatchUpdatesTo(this);
        }
    }


    static class TaskHolder extends RecyclerView.ViewHolder{

        final TaskItemBinding binding;

        public TaskHolder(TaskItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;


        }
    }
}
