package com.globallogic.dc.model;

import java.util.List;

public class SubChapter {

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
}
