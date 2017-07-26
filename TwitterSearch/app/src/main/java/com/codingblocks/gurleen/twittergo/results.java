package com.codingblocks.gurleen.twittergo;

import java.util.ArrayList;

/**
 * Created by hp on 7/8/2017.
 */

public class results {
    ArrayList<status> statuses;

    public results(ArrayList<status> statuses) {
        this.statuses = statuses;
    }

    public void setStatuses(ArrayList<status> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<status> getStatuses() {
        return statuses;
    }
}
