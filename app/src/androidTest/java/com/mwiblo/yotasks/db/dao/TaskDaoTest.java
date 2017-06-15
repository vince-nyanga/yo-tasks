package com.mwiblo.yotasks.db.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mwiblo.yotasks.TestUtil;
import com.mwiblo.yotasks.db.YoTasksDb;
import com.mwiblo.yotasks.db.entity.Task;

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
public class TaskDaoTest {

    private static final String TASK_NAME =  "Groceries";
    private static final String NEW_TASK_NAME = "Shopping";
    private static final int TASK_ID = 1;

    private TaskDao taskDao;
    private YoTasksDb db;

    @Before
    public void setUp(){
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, YoTasksDb.class).build();
        taskDao = db.taskDao();
    }

    @After
    public void tearDown(){
        db.close();
    }

    @Test
    public void insert() throws Exception{
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);
        List<Task> taskList = taskDao.loadTasksSync();
        assertEquals("Task list should be of size = 1", 1,taskList.size());
        assertEquals("Task name should be "+TASK_NAME,TASK_NAME, taskList.get(0).getName());
        assertEquals("Task id should be " + TASK_ID, TASK_ID, taskList.get(0).getId());
    }

    @Test
    public void getTaskByIdSync() throws Exception{
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);
        task = taskDao.getTaskByIdSync(TASK_ID);
        assertNotNull(task);
    }

    @Test
    public void update() throws Exception{
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);
        task = taskDao.getTaskByIdSync(TASK_ID);
        assertNotNull(task);
        task.setName(NEW_TASK_NAME);
        taskDao.update(task);

        Task updatedTask = taskDao.getTaskByIdSync(TASK_ID);
        assertEquals("Task name should be "+NEW_TASK_NAME, NEW_TASK_NAME, updatedTask.getName());
    }

    @Test
    public void delete(){
        Task task = TestUtil.createTask(TASK_NAME);
        taskDao.insert(task);

        List<Task> taskList = taskDao.loadTasksSync();
        assertEquals("Task list should be of size = 1", 1,taskList.size());

        task = taskDao.getTaskByIdSync(TASK_ID);
        taskDao.delete(task);
        taskList = taskDao.loadTasksSync();
        assertEquals("Task list should be of size = 0", 0,taskList.size());

    }

}