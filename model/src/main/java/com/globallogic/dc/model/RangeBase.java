package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class RangeBase extends ProductBase {

    private List<SubChapter> subChapters;
    private List<Item> items;
    private List<Section> sections;

    public List<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    abstract public void addSubChapters(final Collection<SubChapter> subChapters);
    abstract public void addSubChapter(final Collection<SubChapter> subChapter);
    abstract public void addItems(final Collection<Item> items);
    abstract public void addItem(final Collection<Item> item);
    abstract public void addSections(final Collection<Section> sections);
    abstract public void addSection(final Collection<Section> section);

}