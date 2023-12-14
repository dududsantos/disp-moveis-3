package com.example.disp_moveis_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskCreateActivity extends AppCompatActivity {

    private EditText nameEditText, dateEditText;
    private RadioGroup urgencyOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_create);

        nameEditText = findViewById(R.id.name);
        dateEditText = findViewById(R.id.date);
        urgencyOptions = findViewById(R.id.options);

        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    private void addTask() {
        String name = nameEditText.getText().toString();
        String option = urgencyOptions.getTransitionName();
        String textoData = dateEditText.getText().toString();

        if (textoData.matches("\\d{2}/\\d{2}/\\d{4}")) {

        }
        else {
            Toast.makeText(this, "Formato de data inválido", Toast.LENGTH_SHORT).show();
        }

        if (name.isEmpty() || textoData.isEmpty()) {
            Toast.makeText(this, "Há campos não preenchidos!", Toast.LENGTH_SHORT).show();
            return;
        }

        int taskCode = 0;
        if(TaskManager.getTaskList() !=null){
            taskCode = TaskManager.getTaskList().size() + 1;
        }


        Task task = new Task( name, textoData, option, String.valueOf(taskCode));
        TaskManager.getInstance().addTask(task);

        clearFields();
        Toast.makeText(this, "Produto cadastrado.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(TaskCreateActivity.this, TaskListActivity.class);
        startActivity(intent);

    }

    private void clearFields() {
        nameEditText.setText("");
        dateEditText.setText("");
        urgencyOptions.clearCheck();
    }

}