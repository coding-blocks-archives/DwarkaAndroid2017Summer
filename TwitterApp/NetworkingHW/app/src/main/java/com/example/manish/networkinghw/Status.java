package com.example.manish.networkinghw;

import java.util.ArrayList;

/**
 * Created by Manish on 07-07-2017.
 */

public class Status {


    ArrayList<User> statuses  = new ArrayList<>();

    public Status(ArrayList<User> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<User> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<User> statuses) {
        this.statuses = statuses;
    }
}
