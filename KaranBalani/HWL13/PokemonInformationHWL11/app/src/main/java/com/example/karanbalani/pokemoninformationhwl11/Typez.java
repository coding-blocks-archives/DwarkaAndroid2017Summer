package com.example.karanbalani.pokemoninformationhwl11;

import java.io.Serializable;

/**
 * Created by karanbalani on 07/07/17.
 */

class Typez implements Serializable{
    Integer slot;
    Typei type;

    public Typez(Integer slot, Typei type) {
        this.slot = slot;
        this.type = type;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Typei getType() {
        return type;
    }

    public void setType(Typei type) {
        this.type = type;
    }
}
