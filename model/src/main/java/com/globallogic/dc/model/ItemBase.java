package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class ItemBase extends AbstractProduct {

    private Range range;
    private List<Item> items;
    private List<Item> relatedItems;

    public List<Item> getRelatedItems() {
        return this.relatedItems;
    }

    public void setRelatedItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public boolean hasRelatedItems() {
        return this.relatedItems != null;
    }

    public Range getRange() {
        return this.range;
    }

    public void setRange(final Range range) {
        this.range = range;
    }

    public boolean hasRange() {
        return this.range != null;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public boolean hasItems() {
        return this.items != null;
    }

    public void addItems(final Collection<Item> items) {
        this.items.addAll(items);
    }

    public void addItem(final Item item) {
        this.items.add(item);
    }

    public void addRelatedItems(final Collection<Item> relatedItems) {
        this.relatedItems.addAll(relatedItems);
    }

    public void addRelatedItem(final Item relatedItem) {
        this.relatedItems.add(relatedItem);
    }

}