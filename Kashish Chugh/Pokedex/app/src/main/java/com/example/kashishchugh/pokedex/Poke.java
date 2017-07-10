package com.example.kashishchugh.pokedex;

/**
 * Created by kashish chugh on 05-Jul-17.
 */

public class Poke {
    String name,rank,weight,height,base_experience;
    Sprites sprites;
    int id;

    public Poke(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Poke(String name, String rank, String weight, String height, String base_experience, Sprites sprites) {
        this.name = name;
        this.rank = rank;
        this.weight = weight;
        this.height = height;
        this.base_experience = base_experience;
        this.sprites = sprites;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }


    public Sprites getSprites() {

        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getExpeience() {
        return base_experience;
    }
}
