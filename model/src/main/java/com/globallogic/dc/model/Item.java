package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class Item extends ItemBase{

    private Range range;
    private List<Item> items;
    private List<Item> relatedItems;

    public Item(final Range range, final List<Item> items, final List<Item> relatedItems) {
        this.range = range;
        this.items = items;
        this.relatedItems = relatedItems;
    }

    public List<Item> getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(List<Item> relatedItems) {
        this.relatedItems = relatedItems;
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

    @Override
    public void add(Collection<Item> items) {
        this.items.addAll(items);
    }

    @Override
    public boolean hasKey() {
        return this.getKey() != null;
    }

    @Override
    public boolean hasTitle() {
        return this.getTitle() != null;
    }

    @Override
    public boolean hasDescription() {
        return this.getDescription() != null;
    }
}
