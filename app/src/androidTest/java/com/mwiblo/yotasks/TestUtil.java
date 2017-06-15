package com.mwiblo.yotasks;

import com.mwiblo.yotasks.db.entity.Task;
import com.mwiblo.yotasks.db.entity.TaskItem;

import java.util.Date;

/**
 * @author Vincent
 */

public class TestUtil {

    public static Task createTask(String name) {
        Task task = new Task();
        task.setName(name);
        task.setDateCreated(new Date());
        return task;
    }

    public static TaskItem createItem(String name, int taskId){
        TaskItem item = new TaskItem();
        item.setName(name);
        item.setTaskId(taskId);
        item.setDone(false);
        return item;
    }
}
