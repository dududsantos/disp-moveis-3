package com.example.disp_moveis_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {
    private TaskListActivity taskListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        TextView name = findViewById(R.id.titletask);
        TextView date = findViewById(R.id.showDate);
        RadioButton check = findViewById(R.id.checktask);

        Intent intent = getIntent();
        if (intent != null) {
            String taskCode = intent.getStringExtra("Id");
            String taskName = intent.getStringExtra("taskName");
            String taskDate = intent.getStringExtra("taskDate");
            String taskUrgency = intent.getStringExtra("taskUrgency");


            name.setText(taskName);
            date.setText(taskDate);

            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {

                        excluirTarefa(taskName);
                        finish();
                    }
                }
            });
        }

        }
        private void excluirTarefa(String taskName
        ) {

          TaskManager.removeTaskByName(taskName);

    }

    }

