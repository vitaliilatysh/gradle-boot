package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Item extends ItemBase {

    public Item(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Item(
            final String key,
            final String title,
            final String description,
            final Range range,
            final List<Item> items,
            final List<Item> relatedItems) {
        super(key, title, description, range, items, relatedItems);
    }

    public Item(
            final String key,
            final String title,
            final String description,
            final Range range,
            final List<Item> relatedItems) {
        super(key, title, description, range, relatedItems);
    }

    @Override
    protected void doEquals(EqualsBuilder equalsBuilder, Object obj) {
        Item item = (Item) obj;
        equalsBuilder
                .append(this.getKey(), item.getKey())
                .append(this.getTitle(), item.getTitle())
                .append(this.getDescription(), item.getDescription())
                .append(this.getRange(), item.getRange())
                .append(this.getItems(), item.getItems())
                .append(this.getRelatedItems(), item.getRelatedItems());
    }

    @Override
    protected void doHashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getRange())
                .append(this.getItems())
                .append(this.getRelatedItems());
    }
}
