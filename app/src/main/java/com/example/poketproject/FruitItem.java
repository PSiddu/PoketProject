package com.example.poketproject;

public class FruitItem {
    String name;
    String emoji;

    public FruitItem(String name, String emoji) {
        this.name = name;
        this.emoji = emoji;
    }

    public String getDisplayName() {
        return name + " " + emoji;
    }
}
