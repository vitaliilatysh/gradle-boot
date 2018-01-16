package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
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
        return this.relatedItems;
    }

    public void setRelatedItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public boolean hasRelatedItems() {
        return isNotEmpty(this.relatedItems);
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
        return isNotEmpty(this.items);
    }

    public void addItems(final Collection<Item> items) {
        if (isEmpty(this.items)) this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    public void addItem(final Item item) {
        if (isEmpty(this.items)) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public void addRelatedItems(final Collection<Item> relatedItems) {
        if (isEmpty(this.relatedItems)) {
            this.relatedItems = new ArrayList<>();
        }
        this.relatedItems.addAll(relatedItems);
    }

    public void addRelatedItem(final Item relatedItem) {
        if (isEmpty(this.relatedItems)) {
            this.relatedItems = new ArrayList<>();
        }
        this.relatedItems.add(relatedItem);
    }

}