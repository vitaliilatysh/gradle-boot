package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Section extends SectionBase {

    public Section(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Section(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter,
            final List<Range> ranges) {
        super(key, title, description, subChapter, ranges);
    }

    public Section(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter) {
        super(key, title, description, subChapter);
    }

    @Override
    protected void doEquals(EqualsBuilder equalsBuilder, Entity obj) {
        Section section = (Section) obj;
        equalsBuilder
                .append(this.getKey(), section.getKey())
                .append(this.getTitle(), section.getTitle())
                .append(this.getDescription(), section.getDescription())
                .append(this.getSubChapter(), section.getSubChapter())
                .append(this.getRanges(), section.getRanges());
    }

    @Override
    protected void doHashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getSubChapter())
                .append(this.getRanges());
    }
}
