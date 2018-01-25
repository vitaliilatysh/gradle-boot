package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class Range extends RangeBase {

    public Range(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Range(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters,
            final List<Item> items,
            final List<Section> sections) {
        super(key, title, description, subChapters, items, sections);
    }

    public Range(
            final String key,
            final String title,
            final String description,
            final List<Item> items) {
        super(key, title, description, items);
    }

    @Override
    protected void doAddItem(final Item item) {
        if (!item.hasRange() || item.getRange() != this) {
            if (item.hasRange() && item.getRange().containsItem(item)) {
                item.getRange().removeItem(item);
            }
            item.setRange(this);
        } else {
            super.doAddItem(item);
        }
    }

    @Override
    public void addItems(final Collection<Item> items) {
        super.addItems(items);
    }
}
