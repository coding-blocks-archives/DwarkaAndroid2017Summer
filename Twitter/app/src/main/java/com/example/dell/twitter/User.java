package com.example.dell.twitter;

/**
 * Created by dell on 7/7/2017.
 */

public class User {
    String name,profile_image_url_https,user_id;

    public User(String name, String profile_image_url_https, String user_id) {
        this.name = name;
        this.profile_image_url_https = profile_image_url_https;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
