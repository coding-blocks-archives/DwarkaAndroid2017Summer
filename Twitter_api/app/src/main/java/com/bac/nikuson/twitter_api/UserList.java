package com.bac.nikuson.twitter_api;

import java.util.ArrayList;

/**
 * Created by nikus on 07-07-2017.
 */

public class UserList {
    ArrayList<Statuses> statuses;

    public UserList(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }
}
