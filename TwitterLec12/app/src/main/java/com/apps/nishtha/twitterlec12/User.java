package com.apps.nishtha.twitterlec12;

/**
 * Created by nishtha on 7/7/17.
 */

public class User {
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

    public User(String profile_image_url_https, String screen_name, String name) {

        this.profile_image_url_https = profile_image_url_https;
        this.screen_name = screen_name;
        this.name = name;
    }
}
