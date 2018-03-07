package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.Arrays;
import java.util.List;

public class SubChapterBuilder {

    private String key;
    private String title;
    private String description;
    private Chapter chapter;
    private List<Section> sections;
    private List<Range> ranges;

    public SubChapterBuilder() {
    }

    public SubChapterBuilder withKey(final String key) {
        this.key = key;
        return this;
    }

    public SubChapterBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public SubChapterBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public SubChapterBuilder withChapter(final Chapter chapter) {
        this.chapter = chapter;
        return this;
    }

    public SubChapterBuilder withSections(final List<Section> sections) {
        this.sections = sections;
        return this;
    }

    public SubChapterBuilder withRanges(final List<Range> ranges) {
        this.ranges = ranges;
        return this;
    }

    public SubChapter build() {
        return new SubChapter(key, title, description, chapter, sections, ranges);
    }

    public SubChapter buildDefault() {
        return new SubChapter("1", "Title", "Desc");
    }

    public List<SubChapter> buildAllSubChapters() {
        return Arrays.asList(
                new SubChapter("21", "Title", "Desc"),
                new SubChapter("22", "Title", "Desc"),
                new SubChapter("23", "Title", "Desc"),
                new SubChapter("24", "Title", "Desc"));
    }
}
