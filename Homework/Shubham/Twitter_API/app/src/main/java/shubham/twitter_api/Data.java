package shubham.twitter_api;

import java.util.ArrayList;

/**
 * Created by Shubham on 7/7/2017.
 */

public class Data {
    ArrayList<Statuses> statuses;

    public Data(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }
}
