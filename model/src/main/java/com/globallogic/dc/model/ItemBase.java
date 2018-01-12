package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ItemBase extends AbstractProduct {

    private Range range;
    private List<Item> items;
    private List<Item> relatedItems;

    public ItemBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public ItemBase(
            final String key,
            final String title,
            final String description,
            final Range range,
            final List<Item> items,
            final List<Item> relatedItems) {
        super(key, title, description);
        this.range = range;
        this.items = items;
        this.relatedItems = relatedItems;
    }

    public ItemBase(
            final String key,
            final String title,
            final String description,
            final Range range,
            final List<Item> relatedItems) {
        super(key, title, description);
        this.range = range;
        this.relatedItems = relatedItems;
    }

    public List<Item> getRelatedItems() {
        return this.relatedItems;
    }

    public void setRelatedItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public boolean hasRelatedItems() {
        return this.relatedItems != null && !this.relatedItems.isEmpty();
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
        return this.items != null && !this.items.isEmpty();
    }

    public void addItems(final Collection<Item> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
    }

    public void addItem(final Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public void addRelatedItems(final Collection<Item> relatedItems) {
        if (this.relatedItems == null) {
            this.relatedItems = new ArrayList<>();
        }
        this.relatedItems.addAll(relatedItems);
    }

    public void addRelatedItem(final Item relatedItem) {
        if (this.relatedItems == null) {
            this.relatedItems = new ArrayList<>();
        }
        this.relatedItems.add(relatedItem);
    }

}