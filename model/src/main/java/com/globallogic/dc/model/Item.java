package com.globallogic.dc.model;

import java.util.List;

public class Item {

    private List<Item> items;

    public Item(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
