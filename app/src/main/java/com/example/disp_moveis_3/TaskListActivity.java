package com.example.disp_moveis_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        lerArquivo();

        List<Task> taskList = TaskManager.getTaskList();
        if (taskList != null) {
            ListView listView = findViewById(R.id.todolist);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Task task = adapter.getItem(position);

                    if (task != null) {
                        Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);
                        intent.putExtra("Id", task.getTaskCode());
                        intent.putExtra("taskName", task.getTaskName());
                        intent.putExtra("taskDate", task.getTaskDate());
                        intent.putExtra("taskUrgency", task.getTaskUrgency());

                        startActivity(intent);
                    }
                }
            });
        }

        Button buttonAddTarefa = findViewById(R.id.button1);

        buttonAddTarefa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                Intent intent = new Intent(TaskListActivity.this, TaskCreateActivity.class);
                startActivity(intent);
                Toast.makeText(TaskListActivity.this, "Tarefa cadastrada com sucesso!!", Toast.LENGTH_SHORT).show();
                atualizarListView();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        salvarArquivo();
    }

    private void lerArquivo() {
        try {
            InputStreamReader arquivo = new InputStreamReader(openFileInput("tasks"));
            BufferedReader bufferedReader = new BufferedReader(arquivo);
            String linha = bufferedReader.readLine();

            while (linha != null) {
                String[] taskData = linha.split(";");

                if (taskData.length >= 4) {
                    Task task = new Task(
                            taskData[0],
                            taskData[1],
                            taskData[2],
                            taskData[3]
                    );

                    TaskManager.getInstance().addTask(task);
                } else {
                    Toast.makeText(this, "Linha inválida: " + linha, Toast.LENGTH_SHORT).show();
                    linha = bufferedReader.readLine();
                }
            }

            arquivo.close();
        } catch (IOException e) {
            Toast.makeText(this, "Não foi possível ler o arquivo de tarefas", Toast.LENGTH_LONG).show();
        }
    }

    private void salvarArquivo() {
        try {
            FileOutputStream arquivo = openFileOutput("tasks", Context.MODE_PRIVATE);
            OutputStreamWriter escritor = new OutputStreamWriter(arquivo);

            List<Task> taskList = TaskManager.getTaskList();

            for (Task produto : taskList) {
                String linha = produto.getTaskCode() + ";" +
                        produto.getTaskName() + ";" +
                        produto.getTaskDate() + ";" +
                        produto.getTaskUrgency() + ";\n";
                escritor.write(linha);
            }

            escritor.close();
            arquivo.close();
        } catch (IOException e) {
            Toast.makeText(this, "Não foi possível salvar o arquivo de produtos", Toast.LENGTH_LONG).show();
        }
    }

    public  void atualizarListView() {

        if (adapter == null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TaskManager.getTaskList());
            ListView listView = findViewById(R.id.todolist);
            listView.setAdapter(adapter);
        }

        List<Task> taskList = TaskManager.getTaskList();
//        adapter.clear();
//        adapter.addAll(taskList);
//        adapter.notifyDataSetChanged();
    }


}