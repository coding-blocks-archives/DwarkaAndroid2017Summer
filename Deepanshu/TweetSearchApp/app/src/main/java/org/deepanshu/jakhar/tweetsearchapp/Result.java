package org.deepanshu.jakhar.tweetsearchapp;

import java.util.ArrayList;

/**
 * Created by Deepanshu on 07/07/2017.
 */

public class Result {
    ArrayList<Status> statuses;

    public Result(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }
}
