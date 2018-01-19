package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class SubChapter extends SubChapterBase {

    public SubChapter(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public SubChapter(
            final String key,
            final String title,
            final String description,
            final Chapter chapter,
            final List<Section> sections,
            final List<Range> ranges) {
        super(key, title, description, chapter, sections, ranges);
    }

    @Override
    protected void doEquals(final EqualsBuilder equalsBuilder, final Aggregate obj) {
        final SubChapter subChapter = (SubChapter) obj;
        equalsBuilder
                .append(this.getKey(), subChapter.getKey())
                .append(this.getTitle(), subChapter.getTitle())
                .append(this.getDescription(), subChapter.getDescription())
                .append(this.getChapter(), subChapter.getChapter())
                .append(this.getSections(), subChapter.getSections())
                .append(this.getRanges(), subChapter.getRanges());
    }

    @Override
    protected void doHashCode(final HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getChapter())
                .append(this.getSections())
                .append(this.getRanges());
    }


    @Override
    public void setChapter(final Chapter chapter) {
        if (this.getChapter() != chapter) {
            super.setChapter(chapter);
        }
    }
}
