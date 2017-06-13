package com.mwiblo.yotasks.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(tableName = "items",
foreignKeys = {
        @ForeignKey(entity = Task.class,
        parentColumns = "id",
        childColumns = "taskId",
        onDelete = CASCADE)},
indices = {
        @Index(value = "taskId")
})

public class TaskItem {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int taskId;
    private String name;
    private boolean done;


    public TaskItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }


    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
