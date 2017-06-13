package com.mwiblo.yotasks.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


import java.util.Date;

/**
 * @author Vincent
 */
@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Date dateCreated;


    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}
