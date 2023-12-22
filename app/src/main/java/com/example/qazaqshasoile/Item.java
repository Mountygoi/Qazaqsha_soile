package com.example.qazaqshasoile;

public class Item {

    String name;
    int suret;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuret() {
        return suret;
    }

    public void setSuret(int suret) {
        this.suret = suret;
    }

    public Item(String name, int suret) {
        this.name = name;
        this.suret = suret;
    }
}
