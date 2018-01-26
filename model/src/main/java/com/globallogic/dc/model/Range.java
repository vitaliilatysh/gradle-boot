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
    protected void doAddSubChapter(final SubChapter subChapter) {
        if (!hasSubChapters() || !subChapter.containsRange(this)) {
            super.doAddSubChapter(subChapter);
        }
        if (!subChapter.hasRanges()) {
            subChapter.addRange(this);
        }
    }

    @Override
    public void addSubChapters(final Collection<SubChapter> subChapters) {
        super.addSubChapters(subChapters);
    }

    @Override
    protected void doAddSection(final Section section) {
        if (!hasSections() || !section.containsRange(this)) {
            super.doAddSection(section);
        }
        if (!section.hasRanges()) {
            section.addRange(this);
        }
    }

    @Override
    public void addSections(final Collection<Section> sections) {
        super.addSections(sections);
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
    public void addItems(final Collection<Item> items) {
        super.addItems(items);
    }
}
