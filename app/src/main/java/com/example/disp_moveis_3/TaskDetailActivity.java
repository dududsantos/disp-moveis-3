package com.example.disp_moveis_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Button buttonAdd = findViewById(R.id.button1);
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                Intent intent = new Intent(TaskDetailActivity.this, TaskCreateActivity.class);
                startActivity(intent);
            }
        });
    }

}