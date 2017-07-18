package com.example.kashishchugh.twitter;

import java.util.ArrayList;

/**
 * Created by kashish chugh on 07-Jul-17.
 */

public class Tweet {
    ArrayList<Statuses> statuses;

    public Tweet(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }
}
