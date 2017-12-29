package com.josepbernad.todolist.ActivityControllers;

/**
 * Created by Josep Bernad on 29/12/2017.
 * BCN - Mallorca
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.josepbernad.todolist.R;

public class MainActivityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
