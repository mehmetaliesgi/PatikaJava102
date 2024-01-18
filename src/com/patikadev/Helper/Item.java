package com.patikadev.Helper;

public class Item {
    private int key;
    private String value;

    public Item(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
