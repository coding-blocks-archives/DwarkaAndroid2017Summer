package com.example.chato.twitter;

/**
 * Created by chato on 7/7/2017.
 */

public class User {
    public User(String profile_image_url_https, String screen_name, String name) {
        this.profile_image_url_https = profile_image_url_https;
        this.screen_name = screen_name;
        this.name = name;
    }

    String profile_image_url_https,screen_name,name;


    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getName() {
        return name;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setName(String name) {
        this.name = name;
    }
}