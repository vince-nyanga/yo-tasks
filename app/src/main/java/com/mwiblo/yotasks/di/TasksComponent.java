package com.mwiblo.yotasks.di;

import com.mwiblo.yotasks.viewmodel.TaskListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Vincent
 */

@Singleton
@Component(modules = {TasksModule.class})
public interface TasksComponent {
    void inject(TaskListViewModel taskListViewModel);
}
