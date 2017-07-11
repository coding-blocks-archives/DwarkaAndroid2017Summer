package com.example.karanbalani.twittersearchl12;

import java.util.ArrayList;

/**
 * Created by karanbalani on 07/07/17.
 */

public class InitialResult {
    ArrayList<Statuses> statuses = new ArrayList<>();

    public InitialResult(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }
}
