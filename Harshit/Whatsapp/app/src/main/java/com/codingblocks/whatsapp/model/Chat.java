package com.codingblocks.whatsapp.model;

import java.io.Serializable;

/**
 * Created by the-dagger on 24/06/17.
 */

public class Chat implements Serializable{

    String name,description,time;

    public Chat(String name, String description, String time) {
        this.name = name;
        this.description = description;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
}
