package com.globallogic.dc.model;

public class SubChapter {

    private Section section;
    private Range range;

    public SubChapter(Section section) {
        this.section = section;
    }

    public SubChapter(Range range) {
        this.range = range;
    }

    public SubChapter(Section section, Range range) {
        this.section = section;
        this.range = range;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
