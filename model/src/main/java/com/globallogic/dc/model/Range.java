package com.globallogic.dc.model;

import java.util.List;

public class Range {

    private List<SubChapter> subChapters;
    private List<Item> items;
    private List<Section> sections;

    public Range(final List<SubChapter> subChapters, final List<Item> items, final List<Section> sections) {
        this.subChapters = subChapters;
        this.items = items;
        this.sections = sections;
    }

    public List<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }
}
