package com.codingblocks.tododb.model;

/**
 * Created by harshit on 14/07/17.
 */

public class Task {

    String taskName;
    int id;
    boolean done;

    public Task(String taskName, boolean done) {
        this.taskName = taskName;
        this.done = done;
    }

    public Task(String taskName, int id, boolean done) {
        this.taskName = taskName;
        this.id = id;
        this.done = done;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }
}
