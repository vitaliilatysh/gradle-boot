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
            final List<Item> relatedItems,
            final List<Section> sections) {
        super(key, title, description, subChapters, relatedItems, sections);
    }

    public Range(
            final String key,
            final String title,
            final String description,
            final List<Item> relatedItems) {
        super(key, title, description, relatedItems);
    }

    @Override
    protected void doAddItem(final Item item) {
        if (!item.hasRange() || item.getRange() != this) {
            item.setRange(this);
        } else {
            super.doAddItem(item);
        }
    }

    @Override
    public void addItems(final Collection<Item> relatedItems) {
        super.addItems(relatedItems);
    }
}
