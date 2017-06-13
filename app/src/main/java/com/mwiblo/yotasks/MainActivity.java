package com.mwiblo.yotasks;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mwiblo.yotasks.ui.tasks.AddTaskFragment;
import com.mwiblo.yotasks.ui.tasks.TaskListFragment;

public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new
                    TaskListFragment()).commit();
        }

    }


    public void showAddTaskView(){
        new AddTaskFragment().show(getSupportFragmentManager(), "add_task");
    }


    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }
}
