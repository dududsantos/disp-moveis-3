package com.example.disp_moveis_3;

import androidx.annotation.NonNull;

import java.util.Date;

public class Task {

    private String taskName, taskUrgency;
    private Date taskDate;

    public Task(String taskName, Date taskDate, String taskUrgency ) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskUrgency = taskUrgency;

    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
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
