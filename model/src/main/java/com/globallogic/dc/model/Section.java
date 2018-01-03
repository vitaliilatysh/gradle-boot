package com.globallogic.dc.model;

import java.util.List;

public class Section {

    private List<Chapter> chapters;
    private Range range;

    public Section(Range range) {
        this.range = range;
    }

    public Section(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Section(List<Chapter> chapters, Range range) {
        this.chapters = chapters;
        this.range = range;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
