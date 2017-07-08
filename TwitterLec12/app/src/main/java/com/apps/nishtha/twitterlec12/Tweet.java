package com.apps.nishtha.twitterlec12;

import java.util.ArrayList;

/**
 * Created by nishtha on 7/7/17.
 */

public class Tweet {
    ArrayList<Statuses> statuses;

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public Tweet(ArrayList<Statuses> statuses) {

        this.statuses = statuses;
    }
}
