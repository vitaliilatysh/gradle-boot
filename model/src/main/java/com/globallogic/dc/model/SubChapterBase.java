package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class SubChapterBase extends AbstractProduct {

    private Chapter chapter;
    private List<Section> sections;
    private List<Range> ranges;


    public Chapter getChapter() {
        return this.chapter;
    }

    public void setChapter(final Chapter chapter) {
        this.chapter = chapter;
    }

    public boolean hasChapter() {
        return this.chapter != null;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public boolean hasSections() {
        return this.sections != null;
    }

    public List<Range> getRanges() {
        return this.ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public boolean hasRanges() {
        return this.ranges != null;
    }

    public void addSections(final Collection<Section> sections) {
        this.sections.addAll(sections);
    }

    public void addSection(final Section section) {
        this.sections.add(section);
    }

    public void addRanges(final Collection<Range> ranges) {
        this.ranges.addAll(ranges);
    }

    public void addRange(final Range range) {
        this.ranges.add(range);
    }

}