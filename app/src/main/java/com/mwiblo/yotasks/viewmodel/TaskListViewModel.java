package com.mwiblo.yotasks.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mwiblo.yotasks.db.entity.Task;
import com.mwiblo.yotasks.di.Injectable;
import com.mwiblo.yotasks.di.TasksComponent;
import com.mwiblo.yotasks.repository.DataRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Vincent
 */

public class TaskListViewModel extends ViewModel implements Injectable {

    @Inject
    public DataRepository repository;



    @Override
    public void inject(TasksComponent tasksComponent) {
        tasksComponent.inject(this);
    }

    public LiveData<List<Task>> getTasks(){
        return repository.getAllTasks();
    }

    public void addTask(String name){
        Task task = new Task();
        task.setDateCreated(new Date());
        task.setName(name);
        repository.addTask(task);
    }
}
