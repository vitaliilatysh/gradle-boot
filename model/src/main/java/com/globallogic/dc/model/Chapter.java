package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

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
    protected void doEquals(final EqualsBuilder equalsBuilder, final Aggregate obj) {
        final Chapter chapter = (Chapter) obj;
        equalsBuilder
                .append(this.getKey(), chapter.getKey())
                .append(this.getTitle(), chapter.getTitle())
                .append(this.getDescription(), chapter.getDescription())
                .append(this.getSubChapters(), chapter.getSubChapters());
    }

    @Override
    protected void doHashCode(final HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getSubChapters());
    }

    @Override
    public void addSubChapter(final SubChapter subChapter) {
        if (isEmpty(this.getSubChapters())) {
            super.addSubChapter(subChapter);
            if (subChapter.getChapter() == null) {
                subChapter.setChapter(this);
            }
        } else {
            if (subChapter.getChapter() == null) {
                this.getSubChapters().add(subChapter);
                subChapter.setChapter(this);
            }
        }
    }

    @Override
    public void addSubChapters(final Collection<SubChapter> subChapters) {
        for (SubChapter subChapter : subChapters) {
            subChapter.setChapter(this);
        }
        super.addSubChapters(subChapters);
    }
}
