package com.mwiblo.yotasks.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mwiblo.yotasks.db.entity.Task;

import java.util.List;

/**
 * @author Vincent
 */

@Dao
public interface TaskDao {

    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> loadTasks();

    @Query("SELECT * FROM tasks WHERE id = :id")
    LiveData<Task> getTaskById(int id);

    @Insert
    void insert (Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
