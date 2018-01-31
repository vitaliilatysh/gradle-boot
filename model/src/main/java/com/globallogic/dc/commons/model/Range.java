package com.globallogic.dc.commons.model;

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
    protected void doAddSubChapter(final SubChapter subChapter) {
        if (!hasSubChapters() || !this.containsSubChapter(subChapter)) {
            super.doAddSubChapter(subChapter);
        }
        if (!subChapter.hasRanges() || !subChapter.containsRange(this)) {
            subChapter.addRange(this);
        }
    }

    @Override
    protected void doAddSection(final Section section) {
        if (!hasSections() || !this.containsSection(section)) {
            super.doAddSection(section);
        }
        if (!section.hasRanges() || !section.containsRange(this)) {
            section.addRange(this);
        }
    }

    @Override
    protected void doAddItem(final Item item) {
        if (!item.hasRange() || item.getRange() != this) {
            item.setRange(this);
        } else {
            super.doAddItem(item);
        }
    }
}
