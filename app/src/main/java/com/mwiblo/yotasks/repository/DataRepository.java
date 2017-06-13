package com.mwiblo.yotasks.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.mwiblo.yotasks.AppExecutors;
import com.mwiblo.yotasks.db.YoTasksDb;
import com.mwiblo.yotasks.db.entity.Task;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Vincent
 */

public class DataRepository {

    @Inject
    public  YoTasksDb db;

    @Inject
    public AppExecutors appExecutors;



    public DataRepository(YoTasksDb db, AppExecutors appExecutors){
        this.db = db;
        this.appExecutors = appExecutors;

    }


    public LiveData<List<Task>> getAllTasks(){
        return db.taskDao().loadTasks();
    }

    public void addTask(final Task task){
        appExecutors.databaseIO().execute(new Runnable() {
            @Override
            public void run() {
                db.taskDao().insert(task);
            }
        });

    }

    public void updateTask(final Task task){
        appExecutors.databaseIO().execute(new Runnable() {
            @Override
            public void run() {
                db.taskDao().update(task);
            }
        });

    }

    public void deleteTask(final Task task){
        appExecutors.databaseIO().execute(new Runnable() {
            @Override
            public void run() {
                db.taskDao().delete(task);
            }
        });

    }



}
