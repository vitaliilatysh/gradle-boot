package com.globallogic.dc.model;

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
            final List<Item> relatedItems,
            final List<String> items) {
        super(key, title, description, range, relatedItems, items);
    }

    public Item(
            final String key,
            final String title,
            final String description,
            final Range range,
            final List<String> items) {
        super(key, title, description, range, items);
    }

    @Override
    public void setRange(final Range range) {
        if (hasRange() && this.getRange().containsItem(this)) {
            this.getRange().removeItem(this);
        }
        super.setRange(range);
        range.addItem(this);
    }
}
