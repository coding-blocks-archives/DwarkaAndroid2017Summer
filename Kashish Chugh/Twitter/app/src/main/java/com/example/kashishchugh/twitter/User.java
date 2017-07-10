package com.example.kashishchugh.twitter;

/**
 * Created by kashish chugh on 07-Jul-17.
 */

class User {
    String profile_image_url_https,name,screen_name;

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getName() {
        return name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public User(String profile_image_url_https, String name, String screen_name) {
        this.profile_image_url_https = profile_image_url_https;
        this.name = name;
        this.screen_name = screen_name;

    }
}
