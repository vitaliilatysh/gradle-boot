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
    protected boolean doEquals(final Object obj) {
        SubChapter subChapter = (SubChapter) obj;
        return new EqualsBuilder()
                .append(this.getKey(), subChapter.getKey())
                .append(this.getTitle(), subChapter.getTitle())
                .append(this.getDescription(), subChapter.getDescription())
                .append(this.getChapter(), subChapter.getChapter())
                .append(this.getSections(), subChapter.getSections())
                .append(this.getRanges(), subChapter.getRanges())
                .isEquals();
    }

    @Override
    protected int doHashCode() {
        return new HashCodeBuilder(17,37)
                .append(this.getKey())
                .append(this.getTitle())
                .append(this.getDescription())
                .append(this.getChapter())
                .append(this.getSections())
                .append(this.getRanges())
                .toHashCode();
    }
}
