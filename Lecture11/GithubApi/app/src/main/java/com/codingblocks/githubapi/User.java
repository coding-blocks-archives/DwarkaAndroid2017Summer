package com.codingblocks.githubapi;

/**
 * Created by the-dagger on 05/07/17.
 */

public class User {

    String login,id,avatar_url,url,score;

    public User(String login, String id, String avatar_url, String url, String score) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.score = score;
    }

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
}
