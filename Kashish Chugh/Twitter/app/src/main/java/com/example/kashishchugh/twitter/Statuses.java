package com.example.kashishchugh.twitter;

/**
 * Created by kashish chugh on 07-Jul-17.
 */

public class Statuses {
    String text,link;
    User user;

    public Statuses(String text, String link, User user) {
        this.text = text;
        this.link = link;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public User getUser() {
        return user;
    }
}
