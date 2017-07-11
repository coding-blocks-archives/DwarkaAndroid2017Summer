package com.example.karanbalani.pokemoninformationhwl11;

import java.io.Serializable;

/**
 * Created by karanbalani on 06/07/17.
 */

class Abilities implements Serializable{
    Integer slot;
    Ability ability;

    public Abilities(Integer slot, Ability ability) {
        this.slot = slot;
        this.ability = ability;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
