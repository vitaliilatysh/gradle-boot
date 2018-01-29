package com.globallogic.dc.model;

import java.util.Collection;
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
            final List<String> items,
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
    protected void doAddRelatedItem(final Item relatedItem) {
        if (!hasRelatedItems() || !relatedItem.containsRelatedItem(this)) {
            super.doAddRelatedItem(relatedItem);
        }
        if (!relatedItem.hasRelatedItems() || !relatedItem.containsRelatedItem(this)) {
            relatedItem.addRelatedItem(this);
        }
    }

    @Override
    public void addRelatedItems(final Collection<Item> relatedItems) {
        super.addRelatedItems(relatedItems);
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
