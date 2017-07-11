package com.example.karanbalani.pokemoninformationhwl11;

import java.io.Serializable;

/**
 * Created by karanbalani on 07/07/17.
 */

class Sprites implements Serializable{
    String back_female, back_shiny_female,
            back_default, front_female, front_shiny_female,
            back_shiny, front_default, front_shiny;

    public Sprites(String back_female, String back_shiny_female,
                   String back_default, String front_female, String front_shiny_female,
                   String back_shiny, String front_default, String front_shiny) {
        this.back_female = back_female;
        this.back_shiny_female = back_shiny_female;
        this.back_default = back_default;
        this.front_female = front_female;
        this.front_shiny_female = front_shiny_female;
        this.back_shiny = back_shiny;
        this.front_default = front_default;
        this.front_shiny = front_shiny;
    }

    public String getBack_female() {
        return back_female;
    }

    public void setBack_female(String back_female) {
        this.back_female = back_female;
    }

    public String getBack_shiny_female() {
        return back_shiny_female;
    }

    public void setBack_shiny_female(String back_shiny_female) {
        this.back_shiny_female = back_shiny_female;
    }

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getFront_female() {
        return front_female;
    }

    public void setFront_female(String front_female) {
        this.front_female = front_female;
    }

    public String getFront_shiny_female() {
        return front_shiny_female;
    }

    public void setFront_shiny_female(String front_shiny_female) {
        this.front_shiny_female = front_shiny_female;
    }

    public String getBack_shiny() {
        return back_shiny;
    }

    public void setBack_shiny(String back_shiny) {
        this.back_shiny = back_shiny;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    public void setFront_shiny(String front_shiny) {
        this.front_shiny = front_shiny;
    }
}
