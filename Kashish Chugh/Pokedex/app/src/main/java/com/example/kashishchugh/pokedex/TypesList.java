package com.example.kashishchugh.pokedex;

import java.util.ArrayList;

/**
 * Created by kashish chugh on 06-Jul-17.
 */

public class TypesList {

    ArrayList<Pokem> types;

    public TypesList(ArrayList<Pokem> types) {
        this.types = types;
    }

    public ArrayList<Pokem> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Pokem> types) {
        this.types = types;
    }
}
