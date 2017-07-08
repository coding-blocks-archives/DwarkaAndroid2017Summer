package com.example.karanbalani.twittersearchl12;

/**
 * Created by karanbalani on 07/07/17.
 */

class Statuses {
    String text, link;
    User user;

    public Statuses(String text, String link, User user) {
        this.text = text;
        this.link = link;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
