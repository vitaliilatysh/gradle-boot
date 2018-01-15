package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class RangeBase extends AbstractProduct {

    private List<SubChapter> subChapters;
    private List<Item> items;
    private List<Section> sections;

    public RangeBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public RangeBase(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters,
            final List<Item> items,
            final List<Section> sections) {
        super(key, title, description);
        this.subChapters = subChapters;
        this.items = items;
        this.sections = sections;
    }

    public RangeBase(
            final String key,
            final String title,
            final String description,
            final List<Item> items) {
        super(key, title, description);
        this.items = items;
    }

    public List<SubChapter> getSubChapters() {
        return this.subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public boolean hasSubChapters() {
        return isNotEmpty(this.subChapters);
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public boolean hasSections() {
        return isNotEmpty(this.sections);
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

    public void addSubChapters(final Collection<SubChapter> subChapters) {
        if (this.subChapters == null) {
            this.subChapters = new ArrayList<>();
        }
        this.subChapters.addAll(subChapters);
    }

    public void addSubChapter(final SubChapter subChapter) {
        if (this.subChapters == null) {
            this.subChapters = new ArrayList<>();
        }
        this.subChapters.add(subChapter);
    }

    public void addItems(final Collection<Item> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
    }

    public void addItem(final Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public void addSections(final Collection<Section> sections) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.addAll(sections);
    }

    public void addSection(final Section section) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(section);

    }

}