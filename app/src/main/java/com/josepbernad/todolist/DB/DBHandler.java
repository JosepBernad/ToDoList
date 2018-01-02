package com.josepbernad.todolist.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.josepbernad.todolist.Models.TaskModel;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josep Bernad on 29/12/2017.
 * BCN - Mallorca
 */

public class DBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "admin";

    // Contacts table name
    private static final String TABLE_TASK_NAME = "Task";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CREATION_DATE = "creationDate";
    private static final String KEY_DONE_DATE = "doneDate";
    private static final String KEY_DONE = "done";

    public DBHandler(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Table Task(id, name, creationDate, doneDate, done)
        String CREATE_TASK_TABLE = "CREATE TABLE " + TABLE_TASK_NAME + "("
                + KEY_ID + " TEXT PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_CREATION_DATE + " TEXT,"
                + KEY_DONE_DATE + " TEXT,"
                + KEY_DONE + " INTEGER" + ")";

        db.execSQL(CREATE_TASK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK_NAME);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding new Student Information
    public void addNewTask(TaskModel task) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        Format formatter = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS.SSS");


        String creationDate = formatter.format(task.getCreationDate());
        String doneDate = "";
        if (task.getDoneDate() != null) {
            doneDate = formatter.format(task.getDoneDate());
        }

        values.put(KEY_ID, task.getId());
        values.put(KEY_NAME, task.getName());
        values.put(KEY_CREATION_DATE, creationDate);
        values.put(KEY_DONE_DATE, doneDate);
        values.put(KEY_DONE, task.isDone());

        // Inserting Row
        db.insert(TABLE_TASK_NAME, null, values);
        db.close(); // Closing database connection

        Log.v("Piratilla","Task with name: " + task.getName() + "saved!");
    }

    public List<TaskModel> getAllTasks() {

        List<TaskModel> taskList = new ArrayList<TaskModel>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TASK_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TaskModel task = new TaskModel(cursor.getString(0));

                task.setName(cursor.getString(1));

                DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS.SSS");

                String creationDate = cursor.getString(2);
                try {
                    task.setCreationDate(formatter.parse(creationDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String doneDate = cursor.getString(3);
                if (!doneDate.equals("")) {
                    try {
                        task.setCreationDate(formatter.parse(doneDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                task.setDone(Boolean.valueOf(cursor.getString(4)));

                // Adding task to list
                taskList.add(task);

            } while (cursor.moveToNext());
        }

        // return contact list
        return taskList;
    }
}
