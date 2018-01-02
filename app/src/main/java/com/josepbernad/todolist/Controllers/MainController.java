package com.josepbernad.todolist.Controllers;

import android.content.Context;
import android.util.Log;

import com.josepbernad.todolist.DB.DBHandler;
import com.josepbernad.todolist.Models.TaskModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Josep Bernad on 29/12/2017.
 * BCN - Mallorca
 */

public class MainController {

    private DBHandler dataBase;

    public MainController(Context context) {
        this.dataBase = new DBHandler(context);
    }


    public void showYourShitDude() {
        List<TaskModel> tasks = dataBase.getAllTasks();

        for (TaskModel task : tasks) {
            Log.v("Piratilla", task.getName());
        }
    }
}
