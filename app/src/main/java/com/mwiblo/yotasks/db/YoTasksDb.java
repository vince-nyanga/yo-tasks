package com.mwiblo.yotasks.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.mwiblo.yotasks.db.converter.BooleanConverter;
import com.mwiblo.yotasks.db.converter.DateConverter;
import com.mwiblo.yotasks.db.dao.TaskDao;
import com.mwiblo.yotasks.db.dao.TaskItemDao;
import com.mwiblo.yotasks.db.entity.Task;
import com.mwiblo.yotasks.db.entity.TaskItem;

/**
 * @author Vincent
 */

@Database(entities = {Task.class, TaskItem.class}, version = 1)
@TypeConverters({DateConverter.class, BooleanConverter.class})
public abstract class YoTasksDb extends RoomDatabase {
    public static final String DATABASE_NAME = "yo-tasks-db";

    public abstract TaskDao taskDao();

    public abstract TaskItemDao taskItemDao();

}
