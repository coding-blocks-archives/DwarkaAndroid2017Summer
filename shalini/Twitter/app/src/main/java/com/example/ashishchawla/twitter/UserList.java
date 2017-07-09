package com.example.ashishchawla.twitter;

import java.util.ArrayList;

/**
 * Created by ashishchawla on 07/07/17.
 */

public class UserList {

    ArrayList<Status> statuses;

    public UserList( ArrayList<Status> statuses) {
     this.statuses=statuses;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }


    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }
}


