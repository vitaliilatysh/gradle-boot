package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    protected void doEquals(EqualsBuilder equalsBuilder, Entity obj) {
        Range range = (Range) obj;
        equalsBuilder
                .append(this.getKey(), range.getKey())
                .append(this.getTitle(), range.getTitle())
                .append(this.getDescription(), range.getDescription())
                .append(this.getSubChapters(), range.getSubChapters())
                .append(this.getItems(), range.getItems())
                .append(this.getSections(), range.getSections());
    }

    @Override
    protected void doHashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getSubChapters())
                .append(this.getItems())
                .append(this.getSections());
    }
}
