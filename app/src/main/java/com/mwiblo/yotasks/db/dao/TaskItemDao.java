package com.mwiblo.yotasks.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mwiblo.yotasks.db.entity.TaskItem;

import java.util.List;

/**
 * @author Vincent
 */

@Dao
public interface TaskItemDao {

    @Query("SELECT * FROM items WHERE taskId = :taskId")
    LiveData<List<TaskItem>> loadItems(int taskId);

    @Query("SELECT * from items WHERE id = :id")
    LiveData<TaskItem> getItemById(int id);

    @Insert
    void insert(TaskItem item);

    @Update
    void update(TaskItem item);

    @Delete
    void delete(TaskItem item);
}
