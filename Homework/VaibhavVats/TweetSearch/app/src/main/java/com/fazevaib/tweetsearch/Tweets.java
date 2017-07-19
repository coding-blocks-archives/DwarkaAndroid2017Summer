package com.fazevaib.tweetsearch;

import java.util.ArrayList;

/**
 * Created by Vaibhav on 07-07-2017.
 * Project: TweetSearch
 */

public class Tweets
{
    ArrayList<Status> statuses;

    public Tweets(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }
}
