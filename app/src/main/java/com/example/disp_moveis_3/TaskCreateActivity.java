package com.example.disp_moveis_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


    }

    private void addTask() {
        String name = nameEditText.getText().toString();
        String option = urgencyOptions.getTransitionName();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String textoData = dateEditText.getText().toString();
        Date date = null;

        try{
            if (textoData.matches("\\d{2}/\\d{2}/\\d{4}")) {
                 date = formatoData.parse(textoData);
            }
            else {
                Toast.makeText(this, "Formato de data inválido", Toast.LENGTH_SHORT).show();
            }
        }catch (ParseException e) {
            e.printStackTrace();

            Toast.makeText(this, "Erro ao analisar a data", Toast.LENGTH_SHORT).show();
        }

        if (name.isEmpty() || date==null || option.isEmpty()) {
            Toast.makeText(this, "Há campos não preenchidos!", Toast.LENGTH_SHORT).show();
            return;
        }

        String taskCode = String.valueOf(TaskManager.getTaskList().size() + 1);

        Task task = new Task( name, date, option, taskCode);
        TaskManager.getInstance().addTask(task);

        clearFields();
        Toast.makeText(this, "Produto cadastrado.", Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        nameEditText.setText("");
        dateEditText.setText("");
        urgencyOptions.clearCheck();
    }

}