package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Chapter extends ChapterBase {

    public Chapter(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Chapter(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters) {
        super(key, title, description, subChapters);
    }

    @Override
    protected void doEquals(EqualsBuilder equalsBuilder, Entity obj) {
        Chapter chapter = (Chapter) obj;
        equalsBuilder
                .append(this.getKey(), chapter.getKey())
                .append(this.getTitle(), chapter.getTitle())
                .append(this.getDescription(), chapter.getDescription())
                .append(this.getSubChapters(), chapter.getSubChapters());
    }

    @Override
    protected void doHashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getSubChapters())
                .toHashCode();
    }
}
