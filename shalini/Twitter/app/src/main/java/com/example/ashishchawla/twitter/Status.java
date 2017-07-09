package com.example.ashishchawla.twitter;

import java.util.ArrayList;

/**
 * Created by ashishchawla on 07/07/17.
 */

public class Status extends ArrayList<Status> {
    String link;
    String text;
    User user;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status(String link, String text,User user) {
        this.link = link;
        this.text=text;
        this.user = user;
    }

}

