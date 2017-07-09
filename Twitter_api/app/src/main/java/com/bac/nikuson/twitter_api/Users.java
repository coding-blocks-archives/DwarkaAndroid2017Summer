package com.bac.nikuson.twitter_api;

/**
 * Created by nikus on 07-07-2017.
 */

public class Users {
    String profile_image_url_https;
    String user_id;
    String name;


    public Users(String profile_image_url_https, String user_id, String name) {
        this.profile_image_url_https = profile_image_url_https;
        this.user_id = user_id;
        this.name = name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }
}
