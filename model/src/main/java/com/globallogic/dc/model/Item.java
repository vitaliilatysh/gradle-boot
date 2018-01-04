package com.globallogic.dc.model;

import java.util.List;

public class Item {

    private Range range;
    private List<Item> items;

    public Item(final Range range, final List<Item> items) {
        this.range = range;
        this.items = items;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(final Range range) {
        this.range = range;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
