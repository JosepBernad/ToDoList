package com.josepbernad.todolist.ActivityControllers;

/**
 * Created by Josep Bernad on 29/12/2017.
 * BCN - Mallorca
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.josepbernad.todolist.Controllers.MainController;
import com.josepbernad.todolist.R;

public class MainActivityController extends AppCompatActivity {

    MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this.getApplicationContext());
    }

    

}
