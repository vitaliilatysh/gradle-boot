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
    protected boolean doEquals(final Object obj) {
        Range range = (Range) obj;
        return new EqualsBuilder()
                .append(this.getKey(), range.getKey())
                .append(this.getTitle(), range.getTitle())
                .append(this.getDescription(), range.getDescription())
                .append(this.getSubChapters(), range.getSubChapters())
                .append(this.getItems(), range.getItems())
                .append(this.getSections(), range.getSections())
                .isEquals();
    }

    @Override
    protected int doHashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getSubChapters())
                .append(this.getItems())
                .append(this.getSections())
                .toHashCode();
    }
}
