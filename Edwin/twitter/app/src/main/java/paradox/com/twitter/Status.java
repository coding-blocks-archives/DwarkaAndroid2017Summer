package paradox.com.twitter;

/**
 * Created by winbr on 7/7/2017.
 */

public class Status {
    private User user;
    private String link;
    private String place_name;
    private String text;


    public String getFavourite_count() {
        return favourite_count;
    }

    public void setFavourite_count(String favourite_count) {
        this.favourite_count = favourite_count;
    }

    private String favourite_count;

    public String getRetweet_count() {
        return retweet_count;
    }

    private String retweet_count;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
