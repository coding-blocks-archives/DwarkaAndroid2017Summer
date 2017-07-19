package com.codingblocks.firebase;

/**
 * Created by harshitdwivedi on 19/07/17.
 */

public class Todo {

    private String id;
    private String task,status;

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }

    public Todo() {
    }

    public Todo(String id, String task, String status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }


}
