package com.mwiblo.yotasks;

import android.app.Application;

import com.mwiblo.yotasks.di.DaggerTasksComponent;
import com.mwiblo.yotasks.di.TasksComponent;
import com.mwiblo.yotasks.di.TasksModule;

/**
 * @author Vincent
 */

public class YoTasksApp extends Application {

    private TasksComponent tasksComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        tasksComponent = DaggerTasksComponent.builder()
                .tasksModule(new TasksModule(this))
                .build();
    }

    public TasksComponent getTasksComponent() {
        return tasksComponent;
    }



}
