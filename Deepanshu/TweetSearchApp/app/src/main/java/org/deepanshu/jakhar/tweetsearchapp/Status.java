package org.deepanshu.jakhar.tweetsearchapp;

/**
 * Created by Deepanshu on 07/07/2017.
 */

public class Status {
    String text,screen_name,link;
    User user;

    public Status(String text, String screen_name, String link, User user) {
        this.text = text;
        this.screen_name = screen_name;
        this.link = link;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
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
