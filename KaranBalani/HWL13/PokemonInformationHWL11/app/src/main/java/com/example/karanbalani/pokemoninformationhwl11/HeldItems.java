package com.example.karanbalani.pokemoninformationhwl11;

import java.io.Serializable;

/**
 * Created by karanbalani on 07/07/17.
 */

class HeldItems implements Serializable{
    Itemz item;

    public HeldItems(Itemz item) {
        this.item = item;
    }

    public Itemz getItem() {
        return item;
    }

    public void setItem(Itemz item) {
        this.item = item;
    }
}
