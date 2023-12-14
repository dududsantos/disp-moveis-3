package com.example.disp_moveis_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);


        Button buttonAdd = findViewById(R.id.button1);
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                Intent intent = new Intent(TaskListActivity.this, TaskCreateActivity.class);
                startActivity(intent);
            }
        });
    }

}