package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class SubChapter extends SubChapterBase{

    private Chapter chapter;
    private List<Section> sections;
    private List<Range> ranges;

    public SubChapter(final Chapter chapter, final List<Section> sections, final List<Range> ranges) {
        this.chapter = chapter;
        this.sections = sections;
        this.ranges = ranges;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(final Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    @Override
    public void add(Collection<Section> sections) {
        this.sections.addAll(sections);
    }

    @Override
    public boolean hasKey() {
        return this.getKey() != null;
    }

    @Override
    public boolean hasTitle() {
        return this.getTitle() != null;
    }

    @Override
    public boolean hasDescription() {
        return this.getDescription() != null;
    }
}
