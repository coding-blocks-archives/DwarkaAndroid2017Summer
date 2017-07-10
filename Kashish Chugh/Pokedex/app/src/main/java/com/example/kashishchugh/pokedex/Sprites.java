package com.example.kashishchugh.pokedex;

/**
 * Created by kashish chugh on 05-Jul-17.
 */

class Sprites {
    String back_default,front_default;

    public Sprites(String back_default, String front_default) {
        this.back_default = back_default;
        this.front_default = front_default;
    }

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}
