package com.saxena.ayushi.twitterapp;

import java.util.ArrayList;

/**
 * Created by dell pc on 7/7/2017.
 */

public class Twitter {
    ArrayList<Statuses> statuses;

    public Twitter(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }
}
