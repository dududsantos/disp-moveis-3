package com.example.disp_moveis_3;


import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static com.example.disp_moveis_3.TaskManager instance;
    private static List<Task> productList;

    private TaskManager() {
        productList = new ArrayList<>();
    }

    public static synchronized com.example.disp_moveis_3.TaskManager getInstance() {
        if (instance == null) {
            instance = new com.example.disp_moveis_3.TaskManager();
        }
        return instance;
    }

    public static List<Task> getTaskList() {
        return productList;
    }

    public void addTask(Task product) {
        productList.add(product);
    }

    public static Task getTaskByName(String productCode) {
        for (Task product : productList) {
            if (product.getTaskName().equals(productCode)) {
                return product;
            }
        }
        return null;
    }

    public static boolean removeTaskByName(String productCode) {
        for (Task product : productList) {
            if (product.getTaskName().equals(productCode)) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
}