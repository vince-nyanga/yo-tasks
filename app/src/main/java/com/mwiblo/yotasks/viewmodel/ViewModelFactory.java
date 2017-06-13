package com.mwiblo.yotasks.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mwiblo.yotasks.YoTasksApp;
import com.mwiblo.yotasks.di.Injectable;

/**
 * @author Vincent
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private YoTasksApp app;

    public ViewModelFactory(YoTasksApp app){
        this.app =app;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        T t = super.create(modelClass);
        if(t instanceof Injectable){
            ((Injectable)t).inject(app.getTasksComponent());
        }

        return t;
    }
}
