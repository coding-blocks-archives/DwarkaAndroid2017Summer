package com.bac.nikuson.twitter_api;

/**
 * Created by nikus on 07-07-2017.
 */

public class Statuses {
    Users user;
    String text;
    String link;

     public Users getUsers() {
        return user;
    }

    public Statuses(Users users, String text, String link) {
        this.user = users;
        this.text = text;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }
}
