package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.model.Range;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private String key;
    private String title;
    private String description;
    private Range range;
    private List<String> items;
    private List<Item> relatedItems;

    public ItemBuilder() {
    }

    public ItemBuilder withKey(final String key) {
        this.key = key;
        return this;
    }

    public ItemBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public ItemBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public ItemBuilder withRange(final Range range) {
        this.range = range;
        return this;
    }

    public ItemBuilder withItems(final List<String> items) {
        this.items = items;
        return this;
    }

    public ItemBuilder withRelatedItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
        return this;
    }

    public Item build() {
        return new Item(key, title, description, range, items, relatedItems);
    }

    public Item buildDefault() {
        return new Item("1", "Title", "Desc");
    }

    public List<Item> buildAllItems() {
        return Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("52", "Title", "Desc"),
                new Item("53", "Title", "Desc"),
                new Item("54", "Title", "Desc"));
    }
}
