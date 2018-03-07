package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.Arrays;
import java.util.List;

public class RangeBuilder {

    private String key;
    private String title;
    private String description;
    private List<SubChapter> subChapters;
    private List<Section> sections;
    private List<Item> items;

    public RangeBuilder() {
    }

    public RangeBuilder withKey(final String key) {
        this.key = key;
        return this;
    }

    public RangeBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public RangeBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public RangeBuilder withSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
        return this;
    }

    public RangeBuilder withItems(final List<Item> items) {
        this.items = items;
        return this;
    }

    public RangeBuilder withSections(final List<Section> sections) {
        this.sections = sections;
        return this;
    }

    public Range build() {
        return new Range(key, title, description, subChapters, items, sections);
    }

    public Range buildDefault() {
        return new Range("1", "Title", "Desc");
    }

    public List<Range> buildAllRanges() {
        return Arrays.asList(
                new Range("41", "Title", "Desc"),
                new Range("42", "Title", "Desc"),
                new Range("43", "Title", "Desc"),
                new Range("44", "Title", "Desc"),
                new Range("45", "Title", "Desc"),
                new Range("46", "Title", "Desc"));
    }

}