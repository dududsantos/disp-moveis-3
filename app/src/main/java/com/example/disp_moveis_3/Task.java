package com.example.disp_moveis_3;

import androidx.annotation.NonNull;

import java.util.Date;

public class Task {

    private String taskName, taskUrgency, taskCode, taskDate;

    public Task(String taskName, String taskDate, String taskUrgency, String taskCode ) {
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskUrgency = taskUrgency;
    }

    public String getTaskCode(){return taskCode;}

    public void setTaskCode(String code){
        this.taskCode = code;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskUrgency() {
        return taskUrgency;
    }

    public void setTaskUrgency(String taskUrgency) {
        this.taskUrgency = taskUrgency;
    }

    @NonNull
    @Override
    public String toString() {
        return taskName;
    }
}
