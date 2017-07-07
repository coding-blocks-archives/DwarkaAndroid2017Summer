package com.codingblocks.githubapi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by the-dagger on 05/07/17.
 */

public class User implements Parcelable{

    String login,id,avatar_url,url,score;

    public User(String login, String id, String avatar_url, String url, String score) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.score = score;
    }

    protected User(Parcel in) {
        login = in.readString();
        id = in.readString();
        avatar_url = in.readString();
        url = in.readString();
        score = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(id);
        dest.writeString(avatar_url);
        dest.writeString(url);
        dest.writeString(score);
    }
}
