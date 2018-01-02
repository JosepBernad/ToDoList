package com.josepbernad.todolist.Models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Josep Bernad on 29/12/2017.
 * BCN - Mallorca
 */

public class TaskModel {

    final private String id;
    private String name;
    private Date creationDate;
    private Date doneDate;
    private Boolean done;

    public TaskModel(String name, Date creationDate) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.creationDate = creationDate;
        doneDate = null;
        done = false;
    }

    public TaskModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
