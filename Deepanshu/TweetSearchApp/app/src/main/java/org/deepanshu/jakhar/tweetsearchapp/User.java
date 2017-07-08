package org.deepanshu.jakhar.tweetsearchapp;

/**
 * Created by Deepanshu on 07/07/2017.
 */

public class User {
//    @SerializedName("profile_image_url_https")
//    String profileImageUrlHttps;

    String profile_image_url_https,name;

    public User(String profile_image_url_https, String name) {
        this.profile_image_url_https = profile_image_url_https;
        this.name = name;
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
