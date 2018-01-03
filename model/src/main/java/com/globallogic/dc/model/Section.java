package com.globallogic.dc.model;

public class Section {

    private Chapter chapters;
    private Range range;

    public Section(Range range) {
        this.range = range;
    }

    public Chapter getChapters() {
        return chapters;
    }

    public void setChapters(Chapter chapters) {
        this.chapters = chapters;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
