package com.example.chato.twitter;

import java.util.ArrayList;

/**
 * Created by chato on 7/7/2017.
 */

public class UserList {


    ArrayList<Status> statuses;

    public ArrayList<Status> getStatusArrayList() {
        return statuses;
    }

    public void setUserArrayList(ArrayList<Status> statusArrayList) {
        this.statuses = statusArrayList;
    }

    public UserList(ArrayList<Status> statusArrayList) {

        this.statuses = statusArrayList;
    }
}