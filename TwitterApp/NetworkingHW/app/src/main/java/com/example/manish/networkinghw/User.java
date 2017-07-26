package com.example.manish.networkinghw;

/**
 * Created by Manish on 02-07-2017.
 */

public class User {


    String screen_name;
    String text;
    String link;
    String retweet_count;



    public User(String retweet_count, String favourites_count) {
        this.retweet_count = retweet_count;
        this.favourites_count = favourites_count;
    }

    public String getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(String retweet_count) {
        this.retweet_count = retweet_count;
    }

    public String getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(String favourites_count) {
        this.favourites_count = favourites_count;
    }

    String favourites_count;
    UserList user;


    public User(String screen_name, String text, String link, UserList user) {
        this.screen_name = screen_name;
        this.text = text;
        this.link = link;
        this.user = user;

    }

    public UserList getUser() {
        return user;
    }

    public void setUser(UserList user) {
        this.user = user;
    }

    public User(String screen_name, String text, String link) {
        this.screen_name = screen_name;
        this.text = text;
        this.link = link;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
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
}




