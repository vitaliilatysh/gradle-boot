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
        return (this.sections != null) && !(this.sections.isEmpty());
    }

    public List<Range> getRanges() {
        return this.ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public boolean hasRanges() {
        return (this.ranges != null) && !(this.ranges.isEmpty());
    }

    public void addSections(final Collection<Section> sections) {
        if (this.sections != null) this.sections.addAll(sections);
    }

    public void addSection(final Section section) {
        if (this.sections != null) this.sections.add(section);
    }

    public void addRanges(final Collection<Range> ranges) {
        if (this.ranges != null) this.ranges.addAll(ranges);
    }

    public void addRange(final Range range) {
        if (this.ranges != null) this.ranges.add(range);
    }

}