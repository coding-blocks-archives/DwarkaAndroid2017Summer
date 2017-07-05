package com.codingblocks.githubapi;

import java.util.ArrayList;

/**
 * Created by the-dagger on 05/07/17.
 */

public class UserList {


    ArrayList<User> items;

    public ArrayList<User> getUserArrayList() {
        return items;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.items = userArrayList;
    }

    public UserList(ArrayList<User> userArrayList) {

        this.items = userArrayList;
    }
}
