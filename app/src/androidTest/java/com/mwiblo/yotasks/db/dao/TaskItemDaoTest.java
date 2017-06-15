package com.mwiblo.yotasks.db.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mwiblo.yotasks.TestUtil;
import com.mwiblo.yotasks.db.YoTasksDb;
import com.mwiblo.yotasks.db.entity.Task;
import com.mwiblo.yotasks.db.entity.TaskItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Vincent
 */

@RunWith(AndroidJUnit4.class)
public class TaskItemDaoTest {

    private static final String TASK_NAME = "Groceries";
    private static final String ITEM_NAME = "Sugar";
    private static final int ID = 1;

    private TaskItemDao taskItemDao;
    private TaskDao taskDao;
    private YoTasksDb db;

    @Before
    public void setup(){
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, YoTasksDb.class).build();
        taskDao = db.taskDao();
        taskItemDao = db.taskItemDao();
    }

    @After
    public void tearDown(){
        db.close();
    }


    @Test
    public void insert() throws Exception {
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);

        TaskItem item = TestUtil.createItem(ITEM_NAME, ID);
        taskItemDao.insert(item);

        List<TaskItem> taskItems = taskItemDao.loadItemsSync(ID);
        assertEquals("Task items list should be of size 1", 1, taskItems.size());
    }

    @Test
    public void getItemByIdSync() throws Exception {
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);

        TaskItem item = TestUtil.createItem(ITEM_NAME, ID);
        taskItemDao.insert(item);

        item = taskItemDao.getItemByIdSync(ID);
        assertNotNull(item);
    }

    @Test
    public void update() throws Exception {
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);

        TaskItem item = TestUtil.createItem(ITEM_NAME, ID);
        taskItemDao.insert(item);

        item = taskItemDao.getItemByIdSync(ID);
        assertFalse(item.isDone());

        item.setDone(true);
        taskItemDao.update(item);

        item = taskItemDao.getItemByIdSync(ID);
        assertTrue(item.isDone());
    }

    @Test
    public void delete() throws Exception {
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);

        TaskItem item = TestUtil.createItem(ITEM_NAME, ID);
        taskItemDao.insert(item);

        item = taskItemDao.getItemByIdSync(ID);
        taskItemDao.delete(item);

        List<TaskItem> taskItems = taskItemDao.loadItemsSync(ID);
        assertEquals("Task items list should be of size 0", 0, taskItems.size());
    }

}