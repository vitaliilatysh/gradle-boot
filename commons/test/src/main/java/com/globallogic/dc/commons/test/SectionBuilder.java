package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.List;

public class SectionBuilder {

    private String key;
    private String title;
    private String description;
    private SubChapter subChapter;
    private List<Range> ranges;

    public SectionBuilder() {
    }

    public SectionBuilder withKey(final String key) {
        this.key = key;
        return this;
    }

    public SectionBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public SectionBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public SectionBuilder withSubChapter(final SubChapter subChapter) {
        this.subChapter = subChapter;
        return this;
    }

    public SectionBuilder withRanges(final List<Range> ranges) {
        this.ranges = ranges;
        return this;
    }

    public Section build() {
        return new Section(key, title, description, subChapter, ranges);
    }

    public Section buildDefault() {
        return new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
    }
}
