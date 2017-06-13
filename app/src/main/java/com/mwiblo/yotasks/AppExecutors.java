package com.mwiblo.yotasks;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


import javax.inject.Inject;

/**
 * @author Vincent
 */

public class AppExecutors {


    private Executor databaseIO;
    private Executor mainThread;

    @Inject
    public AppExecutors(){
        this(Executors.newSingleThreadExecutor(), new MainThreadExecutor());
    }

    public AppExecutors(Executor databaseIO, Executor mainThread){
        this.databaseIO = databaseIO;
        this.mainThread = mainThread;
    }

    public Executor databaseIO(){
        return databaseIO;
    }

    public Executor mainThread(){
        return mainThread;
    }


    private static class MainThreadExecutor implements Executor{
        private Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable runnable) {
            handler.post(runnable);
        }
    }
}
