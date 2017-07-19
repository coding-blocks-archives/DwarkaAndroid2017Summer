package com.codingblocks.whatsapp.model;

import java.io.Serializable;

/**
 * Created by the-dagger on 24/06/17.
 */

public class Call implements Serializable{

    String name,time,date;

    public Call(String name, String time, String date) {
        this.name = name;
        this.time = time;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
