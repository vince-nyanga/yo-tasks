package com.mwiblo.yotasks.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.mwiblo.yotasks.AppExecutors;
import com.mwiblo.yotasks.YoTasksApp;
import com.mwiblo.yotasks.db.YoTasksDb;
import com.mwiblo.yotasks.repository.DataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Vincent
 */


@Module
public class TasksModule {

    Application application;

    public TasksModule(Application application){
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApplication(){
        return application;
    }

    @Singleton
    @Provides
    AppExecutors providesAppExecutors(){
        return new AppExecutors();
    }

    @Singleton
    @Provides
    YoTasksDb providesDb(Application application){
        return Room.databaseBuilder(application, YoTasksDb.class, YoTasksDb.DATABASE_NAME).build();
    }

    @Provides
    @Singleton
    DataRepository providesDataRepository(YoTasksDb db, AppExecutors executors){
        return new DataRepository(db, executors);
    }
}
