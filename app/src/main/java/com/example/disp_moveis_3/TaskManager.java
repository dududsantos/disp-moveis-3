package com.example.disp_moveis_3;


import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static com.example.disp_moveis_3.TaskManager instance;
    private static List<Task> taskList;

    private TaskManager() {
        taskList = new ArrayList<>();
    }

    public static synchronized com.example.disp_moveis_3.TaskManager getInstance() {
        if (instance == null) {
            instance = new com.example.disp_moveis_3.TaskManager();
        }
        return instance;
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public static Task getTaskByCode(String taskCode) {
        for (Task task : taskList) {
            if (task.getTaskCode().equals(taskCode)) {
                return task;
            }
        }
        return null;
    }

    public static boolean removeTaskByName(String taskCode) {
        for (Task task : taskList) {
            if (task.getTaskName().equals(taskCode)) {
                taskList.remove(task);
                return true;
            }
        }
        return false;
    }

}