package shubham.twitter_api;

/**
 * Created by Shubham on 7/7/2017.
 */

public class Statuses {
    String favourites_count, link;
    User user;

    public Statuses(String favourites_count, String link, User user) {
        this.favourites_count = favourites_count;
        this.link = link;
        this.user = user;
    }

    public String getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(String favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
