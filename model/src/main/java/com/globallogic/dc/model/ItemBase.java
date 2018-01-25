package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

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
        return hasRelatedItems() ? Collections.unmodifiableList(this.relatedItems) : null;
    }

    public void setRelatedItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public boolean hasRelatedItems() {
        return isNotEmpty(this.relatedItems);
    }

    private List<Item> getRelatedItemsSafe() {
        if (relatedItems == null) {
            synchronized (this) {
                if (relatedItems == null)
                    relatedItems = new ArrayList<>();
            }
        }
        return relatedItems;
    }

    public void addRelatedItem(final Item relatedItem) {
        doAddRelatedItem(relatedItem);
    }

    public void addRelatedItems(final Collection<Item> relatedItems) {
        if (relatedItems == null) {
            throw new IllegalArgumentException();
        }
        relatedItems.forEach(this::doAddRelatedItem);
    }

    protected void doAddRelatedItem(final Item relatedItem) {
        getRelatedItemsSafe().add(relatedItem);
    }

    public boolean containsRelatedItem(final Item relatedItem) {
        return getRelatedItemsSafe().contains(relatedItem);
    }

    public void removeRelatedItem(final Item relatedItem) {
        getRelatedItemsSafe().remove(relatedItem);
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
        return hasItems() ? Collections.unmodifiableList(this.items) : null;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public boolean hasItems() {
        return isNotEmpty(this.items);
    }

    private List<Item> getItemsSafe() {
        if (items == null) {
            synchronized (this) {
                if (items == null) {
                    items = new ArrayList<>();
                }
            }
        }
        return items;
    }

    public void addItem(final Item item) {
        doAddItem(item);
    }

    public void addItems(final Collection<Item> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        items.forEach(this::doAddItem);
    }

    protected void doAddItem(final Item item) {
        getItemsSafe().add(item);
    }

    public boolean containsItem(final Item item) {
        return getItemsSafe().contains(item);
    }

    public void removeItem(final Item item) {
        getItemsSafe().remove(item);
    }
}