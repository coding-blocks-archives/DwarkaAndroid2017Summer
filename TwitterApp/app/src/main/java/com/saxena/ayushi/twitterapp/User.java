package com.saxena.ayushi.twitterapp;

/**
 * Created by dell pc on 7/7/2017.
 */

public class User {
    String profile_image_url_https;
    String name;
    String screen_name;

    public User(String profile_image_url_https, String name, String screen_name) {
        this.profile_image_url_https = profile_image_url_https;
        this.name = name;
        this.screen_name = screen_name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
