package com.apps.nishtha.twitterlec12;

/**
 * Created by nishtha on 7/7/17.
 */

public class Statuses {
    String url,text,link;
    User user;

    public Statuses(String url, String text, String link, User user) {
        this.url = url;
        this.text = text;
        this.link = link;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public User getUser() {
        return user;
    }
}
