package com.codingblocks.gurleen.twittergo;

/**
 * Created by hp on 7/8/2017.
 */

public class status {



    String text;
    String link;

    public void setRetweet_count(String retweet_count) {
        this.retweet_count = retweet_count;
    }

    public void setFavourites_count(String favourites_count) {
        this.favourites_count = favourites_count;
    }

    String screen_name;
    Userdata user;
    String retweet_count;
     String       favourites_count;

    public String getRetweet_count() {
        return retweet_count;
    }

    public String getFavourites_count() {
        return favourites_count;
    }

    public Userdata getUser() {
        return user;
    }


    public status(String text, String link, String screen_name, Userdata user, String retweet_count, String favourites_count) {
        this.text = text;
        this.link = link;
        this.screen_name = screen_name;
        this.user = user;
        this.retweet_count = retweet_count;
        this.favourites_count = favourites_count;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setUser(Userdata user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public String getScreen_name() {
        return screen_name;
    }


    public void setText(String text) {
        this.text = text;
    }






}
