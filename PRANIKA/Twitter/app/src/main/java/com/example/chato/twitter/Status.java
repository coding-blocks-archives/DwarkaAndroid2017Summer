package com.example.chato.twitter;

/**
 * Created by chato on 7/7/2017.
 */

public class Status {
    String link;
    String text;
    User user;

    public Status(String link, User user,String text) {
        this.link = link;
        this.text=text;
        this.user = user;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
